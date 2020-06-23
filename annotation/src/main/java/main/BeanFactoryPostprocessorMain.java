package main;/*
@author : Administrator
@create : 2020-06-2020/6/16-23:58

*/

import main.config.BeanFactoryPostProcessorConfig;
import main.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostprocessorMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

    }
}
