package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/15-22:18
 注册进入到ioc 中
    1.componentScan 然后@controller\@service\@repository
    2.bean
        (1)conditional 按照 条件给ioc中注入组件
        (2)includeFilter
    3.@import 导入组件
    4.@import 实现ImportSelector 接口 注入bean  注入的是类名数组
    5.@import 通过实现ImportBeanDefinitionRegistrar 接口注入bean
    6.使用factoryBean 注入bean
*/

import main.entity.Blue;
import main.entity.Person;
import org.springframework.context.annotation.*;

import java.util.LinkedList;

@Configuration
@ComponentScan(value = "main",includeFilters = {@ComponentScan.Filter(type=FilterType.CUSTOM,classes = {Myfilter.class})})
@Import({Blue.class,MyImport.class,MyBeanDeifinitonRegistion.class})
public class SpringConfig {

//    @Scope
//    @Lazy  懒加载
    @Bean("person")
    public Person person(){
        return  new Person(1,"asdf");
    }


    @Conditional({WindowConditionnal.class})
    @Bean("windows")
    public Person person1(){
        return  new Person(3,"window");
    }

    @Conditional({LinuxConditionnal.class})
    @Bean("linux")
    public Person person2(){
        return  new Person(3,"linux");
    }

    @Bean
    public MyFactoryBean getMyfactory(){
        return new MyFactoryBean();
    }

}
