package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/7-16:37
虚引用
*/

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class PhantomReferDemo {


    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRefer = new PhantomReference<>(o1,referenceQueue);
        System.out.println(phantomRefer.get());   //null
        System.out.println("gc前，referenceQueue :"+referenceQueue.poll());
        o1=null;
        System.gc();
        try {
            Thread.sleep(500);  //必须要睡一下，要不然引用队列获取不到
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(phantomRefer.get()); //null
        System.out.println("gc后，referenceQueue :"+referenceQueue.poll());

    }

}
