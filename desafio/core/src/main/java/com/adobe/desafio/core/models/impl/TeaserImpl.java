package com.adobe.desafio.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.desafio.core.models.TeaserModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = { TeaserModel.class, ComponentExporter.class},
        resourceType = TeaserImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TeaserImpl implements TeaserModel {

    static final String RESOURCE_TYPE = "desafio/components/teaserComp";

    @Self
    private SlingHttpServletRequest request;

    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;

    @ValueMapValue
    private String titleTeaser;

    @ValueMapValue
    private String textTeaser;

    @Override
    public String getTitleTeaser() {
        return titleTeaser;
    }

    @Override
    public String getTextTeaser() {
        return textTeaser;
    }

    @Override
    public String getSrc() {
        return null != image ? image.getSrc() : null;
    }

    @Override
    public String getAlt() {
        return null != image ? image.getAlt() : null;
    }

    @Override
    public String getTitle() {
        return null != image ? image.getTitle() : null;
    }

    @Override
    public String getExportedType() {
        return TeaserImpl.RESOURCE_TYPE;
    }
}