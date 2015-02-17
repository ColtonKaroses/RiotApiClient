package com.ckaroses;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by Colton on 2/16/2015.
 */
public class ApiKeyInterceptor implements RequestInterceptor {
    String apiKey;

    public ApiKeyInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.query("api_key", apiKey);
    }
}
