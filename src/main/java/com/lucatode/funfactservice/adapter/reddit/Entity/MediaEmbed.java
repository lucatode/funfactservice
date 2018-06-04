package com.lucatode.funfactservice.adapter.reddit.Entity;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.*;

@JsonPropertyOrder({

})
public class MediaEmbed {

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
