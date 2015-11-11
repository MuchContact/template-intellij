package util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void testRedis() throws Exception {
        Jedis localhost = new Jedis("localhost");
        System.out.println(localhost.get("name"));
        localhost.sadd("tehoe12", "userid1", "usernamelihao");
        System.out.println(localhost.smembers("tehoe12"));
    }
}
