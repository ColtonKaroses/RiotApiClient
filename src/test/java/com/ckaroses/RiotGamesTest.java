package com.ckaroses;

import com.ckaroses.constant.Region;
import com.ckaroses.dto.Champion.Champions;
import com.ckaroses.dto.FeaturedGames.FeaturedGames;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Colton on 2/16/2015.
 */
public class RiotGamesTest {

    Riot riot;

    @Before
    public void before() throws Exception {
        String apiKey = Resources.toString(this.getClass().getResource("apikey.txt"), Charsets.UTF_8);
        riot = RiotApiFactory.getRiotApi(Region.NA, apiKey);
    }

    @Test
    public void featuredGamesTest() {
        FeaturedGames featuredGames = riot.featuredGames();
        Assert.assertNotNull("The list of featured games is null", featuredGames.getGameList());
    }

}
