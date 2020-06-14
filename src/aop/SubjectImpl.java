package aop;/*
@author : Administrator
@create : 2020-06-2020/6/14-23:21

*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface subject{


    public void say();
}

public class SubjectImpl implements subject {
    @Override
    public void say() {
        System.out.println("impl");
    }



    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        subject subjectproxy = (subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new Handler(subject));
        subjectproxy.say();
    }
}

class Handler implements InvocationHandler{

    private  Object target;

    public Handler(Object target){
        this.target=target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dafd");
        method.invoke(target,args);

        return null;
    }
}
