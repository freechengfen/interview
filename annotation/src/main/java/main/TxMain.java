package main;/*
@author : Administrator
@create : 2020-06-2020/6/28-22:28

*/


import main.config.TxConfig;
import main.tx.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();
    }

}
