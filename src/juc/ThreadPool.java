package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-23:37

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //创建5个线程的池
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //创建单个线程的池
        ExecutorService executorService = Executors.newCachedThreadPool(); //创建弹性个线程的池

        //5个线程完成10个任务
        for (int i = 1; i <= 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"线程");
            });

        }
    }


}
