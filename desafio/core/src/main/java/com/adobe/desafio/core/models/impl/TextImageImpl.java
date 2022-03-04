package com.adobe.desafio.core.models.impl;

import com.adobe.desafio.core.models.TextImageModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = TextImageModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TextImageImpl implements TextImageModel {

    private static final Logger LOG = LoggerFactory.getLogger(TextImageImpl.class);

    @SlingObject
    Resource componentResource;

    @Override
    public List<Map<String, String>> getImageText(){
        List<Map<String, String>> imgtxtList=new ArrayList<>();
        try {
            Resource imgtxtContent=componentResource.getChild("imgtext");
            if(imgtxtContent!=null){
                for (Resource imgtxt : imgtxtContent.getChildren()) {
                    Map<String,String> imgtxtMap=new HashMap<>();
                    imgtxtMap.put("imgtexttype",imgtxt.getValueMap().get("imgtexttype",String.class));
                    imgtxtMap.put("titleimgtx",imgtxt.getValueMap().get("titleimgtx",String.class));
                    imgtxtMap.put("textimgtx",imgtxt.getValueMap().get("textimgtx",String.class));
                    imgtxtMap.put("textImgRef",imgtxt.getValueMap().get("textImgRef",String.class));
                    imgtxtMap.put("button01",imgtxt.getValueMap().get("button01",String.class));
                    imgtxtMap.put("button02",imgtxt.getValueMap().get("button02",String.class));
                    imgtxtList.add(imgtxtMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ", imgtxtList.size());
        return  imgtxtList;
    }
}
