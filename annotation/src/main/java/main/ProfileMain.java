package main;/*
@author : Administrator
@create : 2020-06-2020/6/23-23:37

*/


import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ProfileMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfig.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(ComboPooledDataSource.class);
        for (String s : beanNamesForType) {
            System.out.println("name "+s);
        }

    }
}
