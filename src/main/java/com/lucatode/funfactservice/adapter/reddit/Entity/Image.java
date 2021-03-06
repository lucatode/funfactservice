package com.lucatode.funfactservice.adapter.reddit.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.*;

@JsonPropertyOrder({
    "source",
    "resolutions",
    "variants",
    "id"
})
public class Image {

    @JsonProperty("source")
    private Source source;
    @JsonProperty("resolutions")
    private List<Resolution> resolutions = null;
    @JsonProperty("variants")
    private Variants variants;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("resolutions")
    public List<Resolution> getResolutions() {
        return resolutions;
    }

    @JsonProperty("resolutions")
    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    @JsonProperty("variants")
    public Variants getVariants() {
        return variants;
    }

    @JsonProperty("variants")
    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
