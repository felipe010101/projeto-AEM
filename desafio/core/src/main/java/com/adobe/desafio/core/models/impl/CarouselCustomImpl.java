package com.adobe.desafio.core.models.impl;

import com.adobe.desafio.core.models.CarouselCustomModel;
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
        adapters = CarouselCustomModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CarouselCustomImpl implements CarouselCustomModel {

    private static final Logger LOG = LoggerFactory.getLogger(CarouselCustomImpl.class);

    @SlingObject
    Resource componentResource;

    @Override
    public List<Map<String, String>> getSlide(){
        List<Map<String, String>> slideList=new ArrayList<>();
        try {
            Resource slideContent=componentResource.getChild("cardscustom");
            if(slideContent!=null){
                for (Resource card : slideContent.getChildren()) {
                    Map<String,String> slideMap=new HashMap<>();
                    slideMap.put("carouseltitle",card.getValueMap().get("carouseltitle",String.class));
                    slideMap.put("carouseltext",card.getValueMap().get("carouseltext",String.class));
                    slideMap.put("carouselimageref",card.getValueMap().get("carouselimageref",String.class));
                    slideList.add(slideMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ", slideList.size());
        return  slideList;
    }
}
