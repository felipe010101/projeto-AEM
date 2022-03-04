package com.adobe.desafio.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.wcm.core.components.models.Page;
import com.adobe.desafio.core.models.NavigationModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = { NavigationModel.class, ComponentExporter.class},
        resourceType = "src/main/content/jcr_root/apps/desafio/components/navigation",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class NavigationImpl implements NavigationModel {

    @ScriptVariable
    private Page currentPage;

    @ValueMapValue
    private String logonav;

    @Override
    public String getLogoNav() {
        return logonav;
    }
}
