package main;/*
@author : Administrator
@create : 2020-06-2020/6/25-22:49


aop 原理   https://blog.csdn.net/zhoushimiao1990/article/details/89853368
*/

import main.aop.MathCaculate;
import main.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCaculate math = applicationContext.getBean(MathCaculate.class);

        math.div(2,0);

        applicationContext.close();

    }

}
