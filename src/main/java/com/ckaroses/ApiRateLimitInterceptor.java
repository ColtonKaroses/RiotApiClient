package com.ckaroses;

import com.google.common.util.concurrent.RateLimiter;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Created by Colton on 3/15/2015.
 */
public class ApiRateLimitInterceptor implements RequestInterceptor {

    RateLimiter rateLimiter;

    public ApiRateLimitInterceptor(double requestPerSeconds) {
        rateLimiter = RateLimiter.create(requestPerSeconds);
    }

    @Override
    public void apply(RequestTemplate template) {
        if (!rateLimiter.tryAcquire()) {
            throw new ApiRateLimitException();
        }
    }
}
