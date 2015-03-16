package com.ckaroses;

import com.google.common.util.concurrent.RateLimiter;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by Colton on 3/16/2015.
 */
public class ApiRateLimitBlockingInterceptor implements RequestInterceptor {

    RateLimiter rateLimiter;

    public ApiRateLimitBlockingInterceptor(double requestPerSeconds) {
        rateLimiter = RateLimiter.create(requestPerSeconds);
    }

    @Override
    public void apply(RequestTemplate template) {
       rateLimiter.acquire();
    }
}
