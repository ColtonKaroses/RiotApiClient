package com.ckaroses;

import com.ckaroses.constant.Region;
import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by Colton on 2/16/2015.
 */
public class RiotApiFactory {

    public static Riot getRiotApi(Region region, String apiKey) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .requestInterceptor(new ApiKeyInterceptor(apiKey))
                .target(Riot.class, region.getEndpoint());
    }
}
