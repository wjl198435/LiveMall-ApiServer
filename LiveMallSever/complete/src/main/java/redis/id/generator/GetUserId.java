package redis.id.generator;

import com.haiwar.properties.GetProperties;

import static com.haiwar.properties.GetProperties.getProperties;

/**
 * Created by wjl198435 on 5/9/2017.
 */
public class GetUserId {

       static   GetProperties redisProperties=getProperties();

        //c5809078fa6d652e0b0232d552a9d06d37fe819c
        static   IdGenerator idGenerator = IdGenerator.builder()
                .addHost(redisProperties.getRedis_host1(), redisProperties.getRedis_port1(), redisProperties.getRedis_EVALSHA1())
                .addHost(redisProperties.getRedis_host2(), redisProperties.getRedis_port2(), redisProperties.getRedis_EVALSHA2())
                .addHost(redisProperties.getRedis_host3(), redisProperties.getRedis_port3(), redisProperties.getRedis_EVALSHA3())
                .build();

    static public long getUserID(String label,long id){
        long userId= idGenerator.next(label, id);
        return userId;
    }

}
