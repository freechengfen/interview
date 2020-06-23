package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-20:29

//初始化之前调用、初始化之后调用


*/

import main.entity.Green;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanDeifinitonRegistion implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Green.class);
        registry.registerBeanDefinition("green",rootBeanDefinition);

    }

}
