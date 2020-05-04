package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/4-15:11

*/

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) {
        EnumDemo();
    }

     public static void EnumDemo(){
         CountDownLatch count= new CountDownLatch(6);


         for (int i = 1; i <= 6; i++) {
             new Thread(()->{
                 System.out.println(Thread.currentThread().getName()+"被灭");
                 count.countDown();
             },EnumDemo.foreach(i).getName()).start();
         }
         try {
             count.await();
             System.out.println(Thread.currentThread().getName()+"秦统一六国");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }



    public static void useDemo(){

        CountDownLatch count= new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"进门自习");
                count.countDown();
            },String.valueOf(i)).start();
        }
        try {
            count.await();
            System.out.println(Thread.currentThread().getName()+"最后进入");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
