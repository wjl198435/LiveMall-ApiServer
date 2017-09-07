package com.haiwar.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GetProperties {


   static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   static GetProperties loginInfo = appContext.getBean(GetProperties.class);


   static public GetProperties getProperties(){
        return loginInfo;
    }

    @Value("#{configProperties['mysql.url']}")
    private String url;
    @Value("#{configProperties['mysql.userName']}")
    private String userName;
    @Value("#{configProperties['mysql.password']}")
    private String password;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    @Value("#{configProperties['wx.wxspSecret']}")
    private String wxspSecret;
    @Value("#{configProperties['wx.wxspAppid']}")
    private String wxspAppid;

    public String getWxspAppid() {
        return wxspAppid;
    }
    public String getWxspSecret() {
        return wxspSecret;
    }




    //redis  properties
    @Value("#{configProperties['redis.num']}")
    private int redis_num;

    @Value("#{configProperties['redis.host.r1']}")
    private String redis_host1;
    @Value("#{configProperties['redis.port.r1']}")
    private int redis_port1;
    @Value("#{configProperties['redis.EVALSHA.r1']}")
    private String redis_EVALSHA1;

    public int getRedis_num() {
        return redis_num;
    }

    public String getRedis_host1() {
        return redis_host1;
    }

    public int getRedis_port1() {
        return redis_port1;
    }

    public String getRedis_EVALSHA1() {
        return redis_EVALSHA1;
    }

    public String getRedis_host2() {
        return redis_host2;
    }

    public int getRedis_port2() {
        return redis_port2;
    }

    public String getRedis_EVALSHA2() {
        return redis_EVALSHA2;
    }

    public String getRedis_host3() {
        return redis_host3;
    }

    public int getRedis_port3() {
        return redis_port3;
    }

    public String getRedis_EVALSHA3() {
        return redis_EVALSHA3;
    }

    @Value("#{configProperties['redis.host.r2']}")
    private String redis_host2;
    @Value("#{configProperties['redis.port.r2']}")
    private int redis_port2;
    @Value("#{configProperties['redis.EVALSHA.r2']}")
    private String redis_EVALSHA2;

    @Value("#{configProperties['redis.host.r3']}")
    private String redis_host3;
    @Value("#{configProperties['redis.port.r3']}")
    private int redis_port3;
    @Value("#{configProperties['redis.EVALSHA.r3']}")
    private String redis_EVALSHA3;


}
