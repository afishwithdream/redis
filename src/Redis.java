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
    *   hash: hset key filed value eg. hset person name jack获取 hget person name, hgetall key获取key内所有的内容.删除hdel
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
}
