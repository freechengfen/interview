package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-23:54

*/

import main.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"config.properties"})
@Configuration
public class BeanFactoryPostProcessorConfig {



    @Bean
    public Person person(){
        return  new Person();
    }


}
