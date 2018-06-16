package com.lucatode.funfactservice.adapter.http;

import java.io.IOException;

public interface HttpPostClient {
    int postJson(String json) throws IOException;
}
