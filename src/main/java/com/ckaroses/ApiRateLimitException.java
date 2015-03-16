package com.ckaroses;

/**
 * Created by Colton on 3/15/2015.
 */
public class ApiRateLimitException extends RuntimeException {

    public ApiRateLimitException() {
        super("API Rate Limit has been exceeded.");
    }

}
