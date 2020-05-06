package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/6-23:46
 弱引用的强度比软引用更弱一些。当 JVM 进行垃圾回收时，无论内存是否充足，都会回收只被弱引用关联的对象。
*/

import java.lang.ref.WeakReference;

public class WeakReferDemo {

    //内存足够的软引用
    static void memory_enough_weakRefe(){

        Object o1 = new Object();
        WeakReference<Object> weakReference= new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1=null;
        System.gc();
        System.out.println("GC后=======================");
        System.out.println(weakReference.get());  //有值

    }

    //-Xms5m Xmx5m -XX:+PrintGCDetails
    static void menory_lock_weakRefe(){

        Object o1=new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o1);
        try {
            System.out.println(o1);
            System.out.println(weakReference);
            o1=null;
            Byte[] bytes = new Byte[1024 * 1024 * 10];  //自动发生GC
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println("GC后===================");
            System.out.println(o1);
            System.out.println(weakReference.get());  //无值
        }




    }
}
