package com.adobe.desafio.core.models;

import com.adobe.cq.wcm.core.components.models.Image;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface TeaserModel extends Image {

    String getTitleTeaser();

    String getTextTeaser();

}