package com.adobe.desafio.core.models;

import com.adobe.cq.wcm.core.components.models.Navigation;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface NavigationModel extends Navigation {

    String getLogoNav();
}
