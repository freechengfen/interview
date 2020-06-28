package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/25-22:22

@EnableAspectJAutoProxy里面是要注册一个名为
org.springframework.aop.config.internalAutoProxyCreator -> AnnotationAwareAspectJAutoProxyCreator 的组件

AnnotationAwareAspectJAutoProxyCreator
initBeanFactory
    ->AspectJAwareAdvisorAutoProxyCreator
        ->AbstractAdvisorAutoProxyCreator
        setBeanFactory --> initBeanFactory
            ->AbstractAutoProxyCreator
            postProcessAfterInitialization  postProcessBeforeInstantiation  setBeanFactory
                ->ProxyProcessorSupport  implement  SmartInstantiationAwareBeanPostProcessor、BeanFactoryAware

    初始化 AnnotationAwareAspectJAutoProxyCreator时是执行
    initializeBean方法
        invokeAwareMethods() //执行setBeanFactory方法
        applyBeanPostProcessorsBeforeInitialization()  执行postprocessor的BeforeInitialization 方法
        invokeInitMethods() 执行 自定义的初始化方法
        applyBeanPostProcessorsAfterInitialization 执行postprocessor的afterInitialization 方法
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
