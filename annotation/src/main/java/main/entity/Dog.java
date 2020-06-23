package main.entity;/*
@author : Administrator
@create : 2020-06-2020/6/16-22:59


//使用 @PostConstruct、 @PreDestroy  初始化方法和销毁方法
*/

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog  {

    public Dog(){
        System.out.println("dog constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("init dog");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("befor destroy dog");
    }
}
