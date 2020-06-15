package main;

import main.config.SpringConfig;
import main.controller.BookController;
import main.entity.Blue;
import main.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class MainDemo {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        BookController controller = applicationContext.getBean(BookController.class);
//        Blue bean = applicationContext.getBean(Blue.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
//        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
//        System.out.println(bean);
    }

}
