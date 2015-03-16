package com.ckaroses.RiotNA;

import com.ckaroses.constant.GameQueueType;
import com.ckaroses.constant.QueueType;
import com.ckaroses.constant.Region;
import com.ckaroses.dto.Game.RecentGames;
import com.ckaroses.dto.League.League;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Colton on 3/15/2015.
 */
public class RiotLeagueTest extends RiotNATestBase {

    static List<Long> summonerIdsList = new ArrayList<Long>();

    @BeforeClass
    public static void beforeClass() {
        summonerIdsList.add(PHREAK_ID);
        summonerIdsList.add(DYRUS_ID);
    }

    @Test
    public void getLeagueSingleSummonerTest() {
        Map<String, List<League>> leagueMap = riot.leaguesBySummonerIds(Region.NA, PHREAK_ID);
        Assert.assertTrue("List is missing Phreak's Id", leagueMap.containsKey(PHREAK_ID.toString()));
        Assert.assertNotNull("Phreak is not ranked in at least one league", leagueMap.get(PHREAK_ID.toString()));
    }

    @Test
    public void getLeagueMultipleSummonerTest() {
        Map<String, List<League>> leagueMap = riot.leaguesBySummonerIds(Region.NA, summonerIdsList);
        Assert.assertTrue("List is missing Phreak's Id", leagueMap.containsKey(PHREAK_ID.toString()));
        Assert.assertNotNull("Phreak is not ranked in at least one league", leagueMap.get(PHREAK_ID.toString()));

        Assert.assertTrue("List is missing Dyrus's Id", leagueMap.containsKey(DYRUS_ID.toString()));
        Assert.assertNotNull("Dyrus is not ranked in at least one league", leagueMap.get(DYRUS_ID.toString()));
    }

    @Test
    public void getLeagueEntrySingleSummonerTest() {
        Map<String, List<League>> leagueMap = riot.leagueEntriesBySummonerIds(Region.NA, PHREAK_ID);
        Assert.assertTrue("List is missing Phreak's Id", leagueMap.containsKey(PHREAK_ID.toString()));
        Assert.assertNotNull("Phreak is not ranked in at least one league", leagueMap.get(PHREAK_ID.toString()));
    }

    @Test
    public void getLeagueEntryRecentGamesMultipleSummonerTest() {
        Map<String, List<League>> leagueMap = riot.leagueEntriesBySummonerIds(Region.NA, summonerIdsList);
        Assert.assertTrue("List is missing Phreak's Id", leagueMap.containsKey(PHREAK_ID.toString()));
        Assert.assertNotNull("Phreak is not ranked in at least one league", leagueMap.get(PHREAK_ID.toString()));

        Assert.assertTrue("List is missing Dyrus's Id", leagueMap.containsKey(DYRUS_ID.toString()));
        Assert.assertNotNull("Dyrus is not ranked in at least one league", leagueMap.get(DYRUS_ID.toString()));
    }

    @Ignore("May be issue with API.  Cannot get TSM information.")
    @Test
    public void getLeagueByTeamTest() {
        Map<String, List<League>> leagueMap = riot.leagueByTeamIds(Region.NA, TSM_ID);
        Assert.assertTrue("List is missing TSM's Id", leagueMap.containsKey(TSM_ID));
        Assert.assertNotNull("TSM is not ranked in at least one league", leagueMap.get(TSM_ID));
    }

    @Test
    public void getChallengerLeagueTest() {
        League league = riot.challenger(Region.NA, GameQueueType.RANKED_SOLO_5x5);
        Assert.assertNotNull("The league DTO has not been received.", league);
        Assert.assertTrue("The Challenger League was not called Challenger", "CHALLENGER".equals(league.getTier()));
    }

}
