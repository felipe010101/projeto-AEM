//package com.adobe.desafio.core.models.classes;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.sling.api.resource.Resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Card {
//
//    private static final Logger LOG = LoggerFactory.getLogger(Card.class);
//
//    private String cardTitle;
//
//    private String cardText;
//
//    private String cardButton;
//
//    private String cardImageRef;
//
//    public Card(Resource resource){
//        try {
//            if(StringUtils.isNotBlank(resource.getValueMap().get("cardtitle", String.class))) {
//                this.cardTitle = resource.getValueMap().get("cardtitle", String.class);
//            }
//            if(StringUtils.isNotBlank(resource.getValueMap().get("cardtext", String.class))) {
//                this.cardText=resource.getValueMap().get("cardtext",String.class);
//            }
//            if(StringUtils.isNotBlank(resource.getValueMap().get("cardbutton", String.class))) {
//                this.cardButton=resource.getValueMap().get("cardbutton",String.class);
//            }
//            if(StringUtils.isNotBlank(resource.getValueMap().get("cardimageref", String.class))) {
//                this.cardImageRef=resource.getValueMap().get("cardimageref",String.class);
//            }
//
//        }catch (Exception e){
//            LOG.info("\n BEAN ERROR : {}",e.getMessage());
//        }
//
//    }
//
//    public String getCardTitle() {
//        return cardTitle;
//    }
//
//    public String getCardText() {
//        return cardText;
//    }
//
//    public String getCardButton() {
//        return cardButton;
//    }
//
//    public String getCardImage() {
//        return cardImageRef;
//    }
//}
