package com.lucatode.funfactservice.adapter.reddit.Entity;

import java.util.HashMap;
import java.util.Map;


import org.codehaus.jackson.annotate.*;


@JsonPropertyOrder({
    "kind",
    "data"
})
public class Child {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("data")
    private Data_ data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("data")
    public Data_ getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data_ data) {
        this.data = data;
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
