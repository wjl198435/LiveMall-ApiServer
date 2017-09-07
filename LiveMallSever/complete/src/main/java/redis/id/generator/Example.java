package redis.id.generator;

/**
 * Created by wjl198435 on 5/9/2017.
 */
import com.haiwar.properties.GetProperties;

import java.util.List;

import static com.haiwar.properties.GetProperties.getProperties;

public class Example {

    public static void main(String[] args) {
        String tab = "order";
        long userId = 123456789;

//        GetProperties redisProperties=getProperties();
//
//        //c5809078fa6d652e0b0232d552a9d06d37fe819c
//        IdGenerator idGenerator = IdGenerator.builder()
//                .addHost(redisProperties.getRedis_host1(), redisProperties.getRedis_port1(), redisProperties.getRedis_EVALSHA1())
//                .addHost(redisProperties.getRedis_host2(), redisProperties.getRedis_port2(), redisProperties.getRedis_EVALSHA2())
//                .addHost(redisProperties.getRedis_host3(), redisProperties.getRedis_port3(), redisProperties.getRedis_EVALSHA3())
//                .build();

      for(int i=0;i<100;i++){
         // long id = idGenerator.next(tab, userId);
          long id =GetUserId.getUserID(tab, userId);
          System.out.println("id:" + id);
          List<Long> result = IdGenerator.parseId(id);

          System.out.println("miliSeconds:" + result.get(0) + ", partition:"
                  + result.get(1) + ", seq:" + result.get(2));
      }


    }
}
