package com.lucatode.funfactservice.adapter.http;

import org.codehaus.jackson.JsonParser;

public interface HttpGetClient {
    JsonParser getGetCallResult(String url);
}
