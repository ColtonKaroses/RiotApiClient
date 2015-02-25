package com.ckaroses;

import com.ckaroses.constant.PlatformId;
import com.ckaroses.constant.Region;
import com.ckaroses.dto.Champion.Champion;
import com.ckaroses.dto.Champion.Champions;
import com.ckaroses.dto.CurrentGame.CurrentGameInfo;
import com.ckaroses.dto.FeaturedGames.FeaturedGames;
import com.ckaroses.dto.Game.RecentGames;
import com.ckaroses.dto.League.League;
import com.ckaroses.dto.Status.Shard;
import com.ckaroses.dto.Status.ShardStatus;
import feign.Param;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Created by Colton on 2/15/2015.
 */
public interface Riot {

    @RequestLine("GET /api/lol/{region}/v1.2/champion")
    Champions champion(@Param("region") Region region);

    @RequestLine("GET /api/lol/{region}/v1.2/champion?freeToPlay={freeToPlay}")
    Champions champion(@Param("region") Region region, @Param("freeToPlay") Boolean freeToPlay);

    @RequestLine("GET /api/lol/{region}/v1.2/champion/{id}")
    Champion champion(@Param("region") Region region, @Param("id") Long id);

    @RequestLine("GET /observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
    CurrentGameInfo currentGameInfo(@Param("platformId") PlatformId platformId,
                                    @Param("summonerId") Long id);

    @RequestLine("GET /observer-mode/rest/featured")
    FeaturedGames featuredGames();

    @RequestLine("GET /api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    RecentGames recentGames(@Param("region") Region region, @Param("summonerId") Long id);

    @RequestLine("GET /api/lol/{region}/v2.5/league/by-summoner/{summonerIds}")
    Map<String, List<League>> leaguesBySummonerIds(@Param("region") Region region,
                                                   @Param("summonerIds") Long id);

    @RequestLine("GET /api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
    Map<String, List<League>> leagueEntriesBySummonerIds(@Param("region") Region region,
                                                         @Param("summonerIds") Long id);

    @RequestLine("GET /api/lol/{region}/v2.5/league/by-team/{teamIds}")
    Map<String, List<League>> leagueByTeamIds(@Param("region") Region region,
                                              @Param("teamIds") Long id);

    @RequestLine("GET /api/lol/{region}/v2.5/league/by-team/{teamIds}/entry")
    Map<String, List<League>> leagueEntriesByTeamIds(@Param("region") Region region,
                                                     @Param("teamIds") Long id);

    @RequestLine("GET /api/lol/{region}/v2.5/league/challenger")
    League challenger(@Param("region") Region region);

    @RequestLine("GET /shards")
    List<Shard> shards();

    @RequestLine("GET /shards/{region}")
    ShardStatus shardStatus(@Param("region") Region region);
}
