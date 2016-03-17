package redis;


import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ConcurrentMap;


public class RedisTest {

    public static void main(String[] args) {
        Object object = null;
        String object1 = (String) object;
        Map<String,String> map = new HashMap<String, String>();
        System.out.println(map.containsKey(null));
        Jedis jedis = new Jedis("192.168.1.206",6382);
        jedis.expire("corpLoginPage_4028815347902ff00147af34fe440001",0);
//        jedis.set("share_center;;lbox","{\"password\":\"postgres\",\"userName\":\"postgres\",\"driverClass\":\"org.postgresql.Driver\",\"jdbcUrl\":\"jdbc:postgresql://192.168.1.206:5432/lbox\"}");
//        jedis.expire("corpRole_default",0);
//        jedis.set("name","ye");
//        System.out.println(jedis.get("name"));
//
//        jedis.append("name"," wan");
//        System.out.println(jedis.get("name"));
//
//        jedis.del("name");
//        System.out.println(jedis.get("name"));
//
//        jedis.mset("name","ye","sex","man");
//        System.out.println(jedis.get("name")+"   "+jedis.get("sex"));
//
//        Map map = new HashMap();
//        map.put("name","ye");
//        map.put("sex","man");
//        List<Map> list= new ArrayList<Map>();
//        list.add(map);
//        jedis.hmset("ye",map);
//        System.out.println(jedis.hgetAll("ye"));
//        jedis.hmset("user", map);
//        List<String> mapList = jedis.hmget("user", "sex", "name");
//        System.out.println(mapList.get(0)+"  "+mapList.get(1));
//
//        jedis.del("xingming");
//        jedis.rpush("xingming","ye");
//        jedis.rpush("xingming","wan");
//        jedis.lpop("xingming");
////        List<String> list1 =jedis.lrange("xingming",0,-1);
//        String filePath = "http://tbccomex.eceibs20.com/index.php?r=front/scorm/shareViewScorm&cid=52e61c55bf01c";
//        int start = filePath.indexOf("cid");
//        String cid = filePath.substring(start+4,filePath.length());
//        filePath = filePath.substring(0,start-1);
//        System.out.println(cid);
//        System.out.println(filePath);
    }
}
