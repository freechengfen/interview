package main;/*
@author : Administrator
@create : 2020-06-2020/6/16-21:41

*/

import main.config.BeanLifeCycleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        applicationContext.close();
    }
}
