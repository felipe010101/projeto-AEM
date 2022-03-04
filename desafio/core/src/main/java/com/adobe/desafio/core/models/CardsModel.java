package com.adobe.desafio.core.models;

import com.adobe.cq.wcm.core.components.models.Carousel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;
import java.util.Map;

@ProviderType
public interface CardsModel extends Carousel {

    public String getSectionTitle();

    public String getSectionText();

    public List<Map<String, String>> getCardsMap();

}