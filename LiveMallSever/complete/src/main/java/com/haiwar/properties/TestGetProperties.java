package com.haiwar.properties;

/**
 * Created by wjl198435 on 1/9/2017.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.haiwar.properties.GetProperties.getProperties;

/**
 * Hello world!
 *
 */
public class TestGetProperties
{
    public static void main( String[] args )
    {
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        GetProperties connInfo = appContext.getBean(GetProperties.class);
        GetProperties connInfo=getProperties();
        System.out.println(connInfo.getUrl());
        System.out.println(connInfo.getUserName());
        System.out.println(connInfo.getPassword());
        System.out.println(connInfo.getWxspAppid());
        System.out.println(connInfo.getWxspSecret());

        System.out.println("redis num:"+connInfo.getRedis_num());


        System.out.println(connInfo.getRedis_host1());
        System.out.println(connInfo.getRedis_host2());
        System.out.println(connInfo.getRedis_host3());

        System.out.println(connInfo.getRedis_port1());
        System.out.println(connInfo.getRedis_port2());
        System.out.println(connInfo.getRedis_port3());

        System.out.println(connInfo.getRedis_EVALSHA1());
        System.out.println(connInfo.getRedis_EVALSHA2());
        System.out.println(connInfo.getRedis_EVALSHA3());


    }
}
