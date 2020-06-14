package aop;/*
@author : Administrator
@create : 2020-06-2020/6/14-23:44

*/

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class CglibEnhance {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SuperClass.class);
        enhancer.setCallback(new AdviceSuper());
        SuperClass superClassProxy = (SuperClass)enhancer.create();
        superClassProxy.superDemo();
    }


}

class  AdviceSuper implements MethodInterceptor{


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("enhancer");
        return   methodProxy.invokeSuper(o,objects);
    }
}

class SuperClass{

    public void superDemo(){
        System.out.println("superDemo");
    }


}
