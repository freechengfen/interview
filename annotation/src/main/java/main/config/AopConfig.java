package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/25-22:22

*/


import main.aop.LogAspect;
import main.aop.MathCaculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public MathCaculate getMathCaculate(){
        return  new MathCaculate();
    }

    @Bean
    public LogAspect getLogAspect(){
        return  new LogAspect();
    }



}
