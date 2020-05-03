package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-23:12

自旋锁的创建
*/

import java.util.concurrent.atomic.AtomicReference;

public class SelfSpinLock {

    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();

        while(!threadAtomicReference.compareAndSet(null,thread)){
        }
        System.out.println(thread.getName()+"进入");
    }


    public void unlock(){
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"退出");
    }


    public static void main(String[] args) {
        SelfSpinLock selfSpinLock = new SelfSpinLock();
        new Thread(()->{
            selfSpinLock.lock();
            System.out.println("t1进入lock");
            selfSpinLock.unlock();
        },"t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            selfSpinLock.lock();
            System.out.println("t2进入lock");
            selfSpinLock.unlock();
        },"t2").start();

    }

}
