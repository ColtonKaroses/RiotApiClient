package com.ckaroses.RiotStatus;

import com.ckaroses.RiotStatus.RiotStatusTestBase;
import com.ckaroses.constant.Region;
import com.ckaroses.dto.Status.Shard;
import com.ckaroses.dto.Status.ShardStatus;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Colton on 2/24/2015.
 */
public class RiotShardsTest extends RiotStatusTestBase {

    @Test
    public void getAllShardsTest() {
        List<Shard> shards = riot.shards();
        assertFalse("No shards could be found", shards.isEmpty());
    }

    @Test
    public void getNAShardsTest() {
        ShardStatus shardStatus = riot.shardStatus(Region.NA);
        assertEquals("No NA shards could be found", "na", shardStatus.getSlug());
    }
}
