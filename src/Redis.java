import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisRedirectionException;

import javax.swing.*;
import java.util.Map;

public class Redis {
    /*
    * redis:非关系型数据库(NOSQL)存储方式为key-value,存放在内存
    *   目录结构
    *       redis.conf 配置文件
    *       redis-cli   客户端
    *       redis-server 服务端
    *   type key查看key类型.
    *   keys * 查看所有的键
    *   del key 删除指定的key-value
    *   redis数据结构: key-value.key:字符串,value:hash(mpa),String,list(linked),set,sortedset(有序集合)
    *   String 存储: set key value    get key value 删除 del key
    *   hash: hset key filed value eg. hsret person name jack获取 hget person name, hgetall key获取key内所有的内容.删除hdel
    *   list(支持重复):可添加元素到列表的头部或尾部(lpush从左边添加,rpush从右边添加)
    *         查询 lrang key start stop 从左侧获取第start到stop 指定key的元素
    *         删除: lpop key 从左边删除一个元素,并返回删除的元素
    *               rpop key 从右边删除一个元素,并返回删除的元素
    *   set(不允许重复) 添加 sadd key value1 value2..获取:smembers key获取key所有元素 删除: srem key
    *   sortedset(有序允许不重复元素) 字符串类型元素.
    *          添加 zadd key score value
    *          查询 zrange key start end
    *          删除 zren key
    *   redis持久化: 将数据从内存保存到硬盘
    *           1.RDB,一定间隔时间,检测key发生变化,进行持久化操作.
    *               redis-conf:
    *                  save 900 1   //900s 一个key变化 持久化
    *                  save 300 10  //300s 10个key变化 持久化
    *                  save 60 10000 //60s 10000key变化 持久化
    *           2.AOF conf文件中appendonly默认关闭,改为yes开启.
    *                   appendfsync always  每次操作进行持久化
    *                   appendfsync everysec    每秒持久化
    *                   appendfsync no    不持久化
    * */
    @Test
    public void redisString(){
        //        1.获取连接,主机,duankou
        Jedis jedis = new Jedis("localhost",6379);//空参构造:localhost,6379端口
//            2.操作String
//        jedis.set("name","20");
//        jedis.del("name");
//        System.out.println(jedis.get("name"));
        //自动过期的String 20s
        jedis.setex("name",20,"jack");
        System.out.println(jedis.get("name"));
    }
    @Test
    public void redisMap(){
        Jedis jedis = new Jedis();
//        System.out.println(jedis.hgetAll("person"));
        jedis.hset("person","name","jack");
        jedis.hset("person","age","22");
        jedis.hset("person","gender","male");
        jedis.close();
        //获取所有键值对,返回值为map
        Map<String, String> map = jedis.hgetAll("person");
        //遍历
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }
    @Test
    public void redisList(){
        Jedis jedis  = new Jedis();
        //链表 左端插入
        /*jedis.lpush("name","jack","sjack2");
        jedis.lpush("age","1","2");*/
        //左侧弹出并返回
        jedis.lpop("age");
//        System.out.println(jedis.lrange("age",0,-1));

    }
    @Test
    public void redisSet(){
        Jedis jedis = new Jedis();
        //set,无序不重复
        jedis.sadd("language","php","java");
        System.out.println(jedis.smembers("language"));
    }
    @Test
    public void redisSorted(){
        Jedis jedis = new Jedis();
        //key - score - value  score为权重,根据权重排正序
        jedis.zadd("people",22,"jack1");
        jedis.zadd("people",2,"jack2");
        jedis.zadd("people",50,"jack3");
        System.out.println(jedis.zrange("people",0,-1));
    }
}
