package com.adobe.desafio.core.models.impl;

import com.adobe.desafio.core.models.IconModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = IconModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class IconImpl implements IconModel {

    private static final Logger LOG = LoggerFactory.getLogger(IconImpl.class);

    @SlingObject
    Resource componentResource;

    @ValueMapValue
    private String iconsTitle;

    @ValueMapValue
    private String iconsText;

    @Override
    public String getIconsTitle() {
        return iconsTitle;
    }

    @Override
    public String getIconsText() {
        return iconsText;
    }

    @Override
    public List<String> getIconType() {
        List<String> icons=new ArrayList<>();
        try {
            Resource icone=componentResource.getChild("icones");
            if(icone!=null){
                for (Resource icon : icone.getChildren()) {
                    icons.add(icon.getValueMap().get("icontip", String.class));
                }
            }
        }catch (Exception e){
        LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",icons.size());
        return icons;
    }
}