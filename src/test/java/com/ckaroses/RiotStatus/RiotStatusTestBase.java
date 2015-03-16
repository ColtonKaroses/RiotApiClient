package com.ckaroses.RiotStatus;

import com.ckaroses.Riot;
import com.ckaroses.RiotApiFactory;
import com.ckaroses.RiotApiKeyReader;
import com.ckaroses.constant.Region;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;

/**
 * Created by Colton on 2/24/2015.
 */
public class RiotStatusTestBase {

    Riot riot;

    @Before
    public void before() throws Exception {
        String apiKey = RiotApiKeyReader.getApiKey();
        riot = RiotApiFactory.getRiotApi("http://status.leagueoflegends.com", apiKey);
    }
}
