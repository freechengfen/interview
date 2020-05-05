package juc;/*
@author : Administrator
@create : 2020-05-2020/5/5-15:09

*/


import java.util.PrimitiveIterator;

class myRunnable  implements Runnable{

    private String lockA;
    private String lockB;

    public myRunnable(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
            synchronized (lockA){
                System.out.println("获得锁"+lockA);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("获得锁"+lockB);
                }
            }


    }
}

public class DeadLockDemo {


    public static void main(String[] args) {
        new Thread(new myRunnable("lockA","lockB"),"aaa").start();
        new Thread(new myRunnable("lockB","lockA"),"aaa").start();
    }

}
