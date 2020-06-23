package main.entity;/*
@author : Administrator
@create : 2020-06-2020/6/16-21:55

*/

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;

@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor");
    }
    public void destroy() throws Exception {
        System.out.println("destroy cat");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing cat");
    }
}
