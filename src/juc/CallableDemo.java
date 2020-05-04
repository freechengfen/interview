package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-23:03
 futureTask 是runnable的实现类  callable又在futureTask中
        callable 相比较runnable而言， 可以获得另一个线程的结果   然后在跟主线程的结果进行合并,对于cpu更加的友好
        futureTask.get方法是一个阻塞方法 直到线程结果出来才会得到 ，因此 futureTask.get 方法一般都放在代码后面


*/

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
            Thread.sleep(2000);
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new MyThread());
        new Thread(integerFutureTask).start();

        int num =10;
        System.out.println("主线程");

        Integer integer = integerFutureTask.get();
        System.out.println("+++++++++++++++++++++++");
        System.out.println(10+integer);

    }





}
