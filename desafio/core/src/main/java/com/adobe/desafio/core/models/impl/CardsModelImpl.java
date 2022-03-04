package com.adobe.desafio.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.desafio.core.models.CardsModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
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
        adapters = { CardsModel.class, ComponentExporter.class},
        resourceType = CardsModelImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CardsModelImpl implements CardsModel {

    private static final Logger LOG = LoggerFactory.getLogger(CardsModelImpl.class);

    @SlingObject
    Resource componentResource;

    static final String RESOURCE_TYPE = "desafio/components/cards";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String sectionTitle;

    @ValueMapValue
    private String sectionText;

    @Override
    public String getSectionTitle() {
        return sectionTitle;
    }

    @Override
    public String getSectionText() {
        return sectionText;
    }

    @Override
    public String getExportedType() {
        return CardsModelImpl.RESOURCE_TYPE;
    }

    @Override
    public List<Map<String, String>> getCardsMap(){
        List<Map<String, String>> cardsList=new ArrayList<>();
        try {
            Resource cardContent=componentResource.getChild("cardcards");
            if(cardContent!=null){
                for (Resource card : cardContent.getChildren()) {
                    Map<String,String> cardMap=new HashMap<>();
                    cardMap.put("cardtitle",card.getValueMap().get("cardtitle",String.class));
                    cardMap.put("cardtext",card.getValueMap().get("cardtext",String.class));
                    cardMap.put("cardbutton",card.getValueMap().get("cardbutton",String.class));
                    cardMap.put("cardimageref",card.getValueMap().get("cardimageref",String.class));
                    cardsList.add(cardMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ", cardsList.size());
        return  cardsList;
    }
}
