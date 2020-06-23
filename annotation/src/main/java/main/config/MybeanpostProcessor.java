package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-23:02
初始化前后调用
主要场景是：判断bean 继承了那个接口 然后给这个bean 赋相应的值
eg: if(bean istanceof  applicationContextWare)
        bean.setApplcationContext(this.applicationContext)

*/

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MybeanpostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before postprocessor==>"+beanName );
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after postprocessor==>" +beanName);
        return bean;
    }

}
