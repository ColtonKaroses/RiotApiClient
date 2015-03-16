package com.ckaroses.RiotNA;

import com.ckaroses.constant.GameQueueType;
import com.ckaroses.constant.Region;
import com.ckaroses.dto.League.League;
import com.ckaroses.dto.Match.MatchDetail;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Colton on 3/16/2015.
 */
public class RiotMatchTest extends RiotNATestBase {

    @Test
    public void getMatchDetailTest() {
        MatchDetail matchDetail = riot.matchById(Region.NA, PHREAK_MATCH_ID);
        Assert.assertNotNull("The match DTO has not been received.", matchDetail);
    }

}
