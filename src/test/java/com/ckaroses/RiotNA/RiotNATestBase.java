package com.ckaroses.RiotNA;

import com.ckaroses.Riot;
import com.ckaroses.RiotApiFactory;
import com.ckaroses.constant.Region;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;

/**
 * Created by Colton on 2/24/2015.
 */
public class RiotNATestBase {

    Riot riot;

    @Before
    public void before() throws Exception {
        String apiKey = Resources.toString(this.getClass().getResource("apikey.txt"), Charsets.UTF_8);
        riot = RiotApiFactory.getRiotApi(Region.NA, apiKey);
    }

}
