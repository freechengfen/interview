package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-23:37

*/

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        proThreadPool();

    }


   public  static void proThreadPool(){
       ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                                               5,
                                               1l,
                                               TimeUnit.SECONDS,
                                               new LinkedBlockingQueue<Runnable>(1),
                                               Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <=6 ; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println("线程"+"\t" +Thread.currentThread().getName());
                });
            }
        }finally {
            threadPoolExecutor.shutdown();
        }


   }


     public void init(){
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //创建5个线程的池  长期固定的任务
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
