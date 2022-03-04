package com.adobe.desafio.core.models.impl;

import com.adobe.desafio.core.models.FeaturesModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = FeaturesModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FeaturesImpl implements FeaturesModel {

    private static final Logger LOG = LoggerFactory.getLogger(FeaturesImpl.class);

    @SlingObject
    Resource componentResource;

    @ValueMapValue
    private String featureTitle;

    @ValueMapValue
    private String featureText;

    @Override
    public String getTitleF() {
        return featureTitle;
    }

    @Override
    public String getTextF() {
        return featureText;
    }

    @Override
    public List<Map<String, String>> getFeatures() {
        List<Map<String, String>> featureList=new ArrayList<>();
        try {
            Resource featureContent=componentResource.getChild("feature");
            if(featureContent!=null){
                for (Resource feature : featureContent.getChildren()) {
                    Map<String,String> featureMap=new HashMap<>();
                    featureMap.put("featuretype",feature.getValueMap().get("featuretype",String.class));
                    featureMap.put("ftitle1",feature.getValueMap().get("ftitle1",String.class));
                    featureMap.put("ftext1",feature.getValueMap().get("ftext1",String.class));
                    featureMap.put("ftitle2",feature.getValueMap().get("ftitle2",String.class));
                    featureMap.put("ftext2",feature.getValueMap().get("ftext2",String.class));
                    featureList.add(featureMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ", featureList.size());
        return  featureList;
    }
}
