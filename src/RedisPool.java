import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.JedisUtils;

public class RedisPool {
    /*
    * jedis连接池
    * */
    @Test
    public void Pool(){
        //创建连接池对象
        JedisPool jedisPool = new JedisPool();  //空参 localhost
//        连接池对象
        Jedis poolResource = jedisPool.getResource();
        //获取结果
        System.out.println(poolResource.zrange("people",0,-1));
        //归还连接池
        poolResource.close();
    }
    @Test
    public void test(){
        System.out.println(JedisUtils.getJedisPool().zrange("people",0,-1));
    }
}
