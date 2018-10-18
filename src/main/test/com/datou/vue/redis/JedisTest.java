package com.datou.vue.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {


    @Test
    public void testJedis() {
        //创建一个Jedis对象，参数：host、port
        Jedis jedis = new Jedis("localhost", 6379);
        //直接使用jedis操作redis。所有jedis的命令都对应一个方法。
        jedis.set("test123", "my first jedis test");
        String string = jedis.get("test123");
        System.out.println(string);
        //关闭连接
        jedis.close();

    }
}
