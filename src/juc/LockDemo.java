package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-19:27

*/


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private int num=0;
    private Lock lock =  new ReentrantLock();
    private Condition condition1 =lock.newCondition();
    private Condition condition2 =lock.newCondition();
    private Condition condition3 =lock.newCondition();

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                try {
                    lockDemo.methodA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                try {
                    lockDemo.methodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                try {
                    lockDemo.methodC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }


    public void methodA() throws InterruptedException {
        lock.lock();
        lock.lockInterruptibly();
        try {
            while(num!=0){
                condition1.await();
            }
            System.out.println("1111111");
            num++;
            condition2.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public void methodB() throws InterruptedException {
        lock.lock();
        try {
            while(num!=1){
                condition2.await();
            }
            System.out.println("2222222");
            num++;
            condition3.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public void methodC() throws InterruptedException {
        lock.lock();
        try {
            while(num!=2){
                condition3.await();
            }
            System.out.println("3333333");
            num=0;
            condition1.signalAll();
        }finally {
            lock.unlock();
        }

    }






}
