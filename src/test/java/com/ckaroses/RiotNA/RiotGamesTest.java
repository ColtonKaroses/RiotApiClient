package com.ckaroses.RiotNA;

import com.ckaroses.constant.Region;
import com.ckaroses.dto.FeaturedGames.FeaturedGames;
import com.ckaroses.dto.Game.RecentGames;
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


    @Test
    public void getRecentGamesTest() {
        RecentGames recentGames = riot.recentGames(Region.NA, PHREAK_ID);
        Assert.assertNotNull("A Recent Games DTO was not returned.", recentGames);
        Assert.assertNotNull("The list of recent games were null", recentGames.getGames());
        Assert.assertNotNull("The list of recent games belong to Phreak",
                            recentGames.getSummonerId() == PHREAK_ID);
    }

}
