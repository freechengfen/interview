package main.aop;/*
@author : Administrator
@create : 2020-06-2020/6/25-22:23


*/


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * aspect 切面类
 * pointCut 配置具体的切入点
 * jointPoint  具体的切入方法
 *
 */


@Aspect
public class LogAspect {


    @Pointcut(value = "execution( public int main.aop.MathCaculate.*(..))")
    public void LogAspect(){
    };


    @Before("LogAspect()")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println("before method :"+"{"+joinPoint.getSignature().getName()+"}");
    }


    @After("execution( public int main.aop.MathCaculate.*(..))")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("after method :"+"{"+joinPoint.getSignature().getName()+"}");
    }

    @AfterReturning(value = "LogAspect()",returning = "result")
    public void afterReturnLog(JoinPoint joinPoint,Object result){
        System.out.println("afterReturn method :"+"{"+joinPoint.getSignature().getName()+"}"+result);
    }


    @AfterThrowing(value = "LogAspect()",throwing = "e")
    public void exceptionLog(JoinPoint joinPoint,Throwable e){
        System.out.println("throwing method :"+"{"+joinPoint.getSignature().getName()+"},exception:"+e);
    }


}
