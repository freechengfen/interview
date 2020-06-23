package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-21:37
多实例的bean的bean的创建只有在调用该bean时才会调用，
销毁 容器不管理  因此当容器进行close() 时 destroyMethod不会执行

单例bean的生命周期
    1.bean 在容器创建的时候就已经创建完毕
    2.创建完毕后会执行 initMethod
    容器销毁的时候会执行 destroyMethod --> context.close()
    也可以通过实现initializingBean 、disposalableBean接口 定义初始化和销毁逻辑
    也可以 @postConstructor\ @preDestroy


*/

import main.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("main")
@Configuration
public class BeanLifeCycleConfig {


    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car getCar(){
        return  new Car();
    }




}
