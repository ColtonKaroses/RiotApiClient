package com.ckaroses.RiotNA;

import com.ckaroses.constant.Region;
import com.ckaroses.dto.Champion.Champion;
import com.ckaroses.dto.Champion.Champions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Colton on 2/16/2015.
 */
public class RiotChampionTest extends RiotNATestBase {

    @Test
    public void getChampionsTest() {
        Champions champions = riot.champion(Region.NA);
        Assert.assertNotNull("The list of champions is null", champions.getChampions());
        Assert.assertTrue("There were not at least 100 champions", champions.getChampions().size() > 100);
    }

    @Test
    public void getFreeToPlayChampionsTest() {
        Champions champions = riot.champion(Region.NA, true);
        Assert.assertNotNull("The list of champions is null", champions.getChampions());
        Assert.assertEquals("There were not exactly 10 free to play champions", 10, champions.getChampions().size());
    }

    @Test
    public void getChampionTest() {
        Champion champion = riot.champion(Region.NA, 1L);
        Assert.assertNotNull("The Champion Object must have an ID", champion.getId());
        Assert.assertNotNull("The Champion Object must have a value for active", champion.isActive());
        Assert.assertNotNull("The Champion Object must have a value for bot enabled", champion.isBotEnabled());
        Assert.assertNotNull("The Champion Object must have a value for bot mm enabled", champion.isBotMmEnabled());
        Assert.assertNotNull("The Champion Object must have a value for free to play", champion.isFreeToPlay());
    }
}
