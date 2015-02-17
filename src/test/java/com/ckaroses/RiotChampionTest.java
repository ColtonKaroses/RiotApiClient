package com.ckaroses;

import com.ckaroses.constant.Region;
import com.ckaroses.dto.Champion.Champions;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Colton on 2/16/2015.
 */
public class RiotChampionTest {

    Riot riot;

    @Before
    public void before() throws Exception {
        String apiKey = Resources.toString(this.getClass().getResource("apikey.txt"), Charsets.UTF_8);
        riot = RiotApiFactory.getRiotApi(Region.NA, apiKey);
    }

    @Test
    public void getChampions() {
        Champions champions = riot.champion(Region.NA);
        Assert.assertNotNull("The list of champions is null", champions.getChampions());
        Assert.assertTrue("There were not at least 100 champions", champions.getChampions().size() > 100);
    }
}
