package springboot.manualproject.controller;/*
@author : Administrator
@create : 2020-05-2020/5/30-15:12

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.manualproject.services.RedisDistrubuteLock;

@RestController
public class UserController {
    @Autowired
    private RedisDistrubuteLock redislock;

    @GetMapping("/lock")
    public void lock(){
        redislock.lockDemo();
    }
}
