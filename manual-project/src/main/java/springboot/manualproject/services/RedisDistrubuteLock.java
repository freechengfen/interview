package springboot.manualproject.services;/*
@author : Administrator
@create : 2020-05-2020/5/30-14:31

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RedisDistrubuteLock {

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void lockDemo(){
        String clientid = UUID.randomUUID().toString().substring(0, 8);
        try {
            Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("lock", clientid, 3, TimeUnit.SECONDS);
            System.out.println("adf:"+aBoolean);
            if(aBoolean){
                new Thread(()-> {
                    redisTemplate.expire("lock",3,TimeUnit.SECONDS);  //每隔1s 设置其时间为
                }).run();
                if(Integer.parseInt(redisTemplate.opsForValue().get("add"))<=100){
                    redisTemplate.opsForValue().increment("add");
                }
            }
        }finally {
            if(redisTemplate.opsForValue().get("lock") .equals(clientid)){
                redisTemplate.delete("lock");
            }
        }

    }




}
