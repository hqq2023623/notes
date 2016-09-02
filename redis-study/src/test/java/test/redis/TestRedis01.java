package test.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Lzj Created on 2016/3/4.
 */
public class TestRedis01 {

    private Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("192.168.56.88", 6379);
    }

    //string类型的操作
    @Test
    public void testString() {
        assertNotNull(jedis);
        //单个值
        jedis.set("name", "lzj");
        assertEquals("lzj", jedis.get("name"));
        //取string的长度
        assertEquals(3L, ((Long) jedis.strlen("name")).longValue());
        //setnx
        jedis.setnx("name", "lzj2");
        assertEquals("lzj", jedis.get("name"));
        //setrange
        jedis.setrange("name", 2, "J");
        assertEquals("lzJ", jedis.get("name"));
        //append操作
        jedis.append("name", " is my lover");
        assertEquals("lzJ is my lover", jedis.get("name"));
        //del操作
        jedis.del("name");
        assertNull(jedis.get("name"));
        //mset操作
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> vals = jedis.mget("k1", "k2");
        assertEquals("v1", vals.get(0));
        assertEquals("v2", vals.get(1));

        jedis.set("age", "20");
        jedis.incr("age");
        assertEquals("21", jedis.get("age"));

    }

    //hash类型的操作,每个hash就是一个对象
    @Test
    public void testHash() {
        jedis.del("users");
        //设置hash的值
        jedis.hset("users", "name", "lzj");
        Map<String, String> map = new HashMap<>();
        map.put("age", "24");
        map.put("sex", "man");
        jedis.hmset("users", map);
        //获取hash的所有数据
        map = jedis.hgetAll("users");
        assertEquals("lzj", map.get("name"));
        assertEquals("24", map.get("age"));
        assertEquals("man", map.get("sex"));
        //获取hash的所有值
        List<String> vals = jedis.hvals("users");
        assertEquals("lzj", vals.get(0));
        assertEquals("24", vals.get(1));
        assertEquals("man", vals.get(2));

        //检测hash中某个field是否存在
        assertTrue(jedis.hexists("users", "name"));
        assertEquals(3L, ((Long) jedis.hlen("users")).longValue());

    }

    //list类型的操作
    @Test
    public void testList() {
        //如果有list1就先删掉，不然会影响测试
        jedis.del("list1");
        //push操作，在list头部添加数据，这里的数据排序就是3,5,2,1
        jedis.lpush("list1", "1", "2", "5", "3");
        //返回第一个元素并删除之
        String first = jedis.lpop("list1");
        assertEquals("3", first);
        //获取list中指定下标的值
        assertEquals("2", jedis.lindex("list1", 1));
        //获取list的长度
        assertEquals(3L, ((Long) jedis.llen("list1")).longValue());
    }

    //sets类型的操作，是string类型的无序集合
    @Test
    public void testSets() {
        jedis.del("sets1", "sets2");
        //add操作
        jedis.sadd("sets1", "l", "z", "j");
        jedis.sadd("sets2", "J", "z", "L");
        //pop操作：随机返回sets中的一个元素并删除之
//        String random = jedis.spop("sets1");
//        assertFalse("1".equals(random));

        //返回一个新的sets，是所有sets的交集
        Set<String> inter = jedis.sinter("sets1", "sets2");
        assertTrue(inter.contains("z"));
        //返回一个新的sets，是所有sets的并集
        Set<String> union = jedis.sunion("sets1", "sets2");
        assertTrue(union.contains("l"));
        assertTrue(union.contains("z"));
        assertTrue(union.contains("j"));
        assertTrue(union.contains("L"));
        assertTrue(union.contains("J"));
        //返回一个新的sets，是第一个sets与后面的所有sets的差集（返回的元素都是第一个sets里面的）
        Set<String> diff = jedis.sdiff("sets1", "set2");
        assertTrue(diff.contains("j"));
        assertTrue(diff.contains("l"));
        assertTrue(diff.contains("z"));

    }

    //Sorted set类型的操作
    @Test
    public void testSortedSets() {
        jedis.del("zset1");
        jedis.zadd("zset1", 0, "123");
        Set<String> zset1 = jedis.zrange("zset1", 0, -1);
        assertTrue(zset1.contains("123"));

    }

    //Redis的常用命令
    @Test
    public void testCmds() {
        jedis.del("name");
        jedis.del("age");
        jedis.del("list1");
        jedis.set("name", "lzj");
        String typeOfName = jedis.type("name");
        assertEquals("string", typeOfName);
        jedis.set("age", "21");
        jedis.incr("age");
        String typeofAge = jedis.type("age");
        assertEquals("string", typeofAge);
        jedis.lpush("list1", "1");
        assertEquals("list", jedis.type("list1"));
        String info = jedis.info();
        System.out.println(info);
    }


}
