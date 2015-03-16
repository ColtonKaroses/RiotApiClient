package com.ckaroses.RiotNA;

import com.ckaroses.*;
import com.ckaroses.constant.Region;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.junit.Before;

/**
 * Created by Colton on 2/24/2015.
 */
public class RiotNATestBase {

    Riot riot;
    static Long PHREAK_ID = 7428L;
    static Long DYRUS_ID = 5908L;
    static Long PHREAK_MATCH_ID = 1752492676L;
    static String TSM_ID = "TEAM-e4936d7b-b80e-4367-a76c-5ccf7388c995";



    @Before
    public void before() throws Exception {
        String apiKey = RiotApiKeyReader.getApiKey();
        riot = Feign.builder()
                .decoder(new GsonDecoder())
                .requestInterceptor(new ApiRateLimitBlockingInterceptor(0.5))
                .requestInterceptor(new ApiKeyInterceptor(apiKey))
                .target(Riot.class, Region.NA.getEndpoint());
    }

}
