package com.ckaroses.RiotNA;

import com.ckaroses.dto.FeaturedGames.FeaturedGames;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Colton on 2/16/2015.
 */
public class RiotGamesTest extends RiotNATestBase {

    @Test
    public void featuredGamesTest() {
        FeaturedGames featuredGames = riot.featuredGames();
        Assert.assertNotNull("The list of featured games is null", featuredGames.getGameList());
    }

}
