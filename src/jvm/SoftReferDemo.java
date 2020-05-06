package jvm;/*
@author : Administrator
@create : 2 020-05-2020/5/6-23:21
软引用：内存够用不gc   内存不够用 gc

*/

import java.lang.ref.SoftReference;

public class SoftReferDemo {



    public static void main(String[] args) {
//        memory_enough_softRefe();
        menory_lock_softRefe();
    }


    //内存足够的软引用
    static void memory_enough_softRefe(){

        Object o1 = new Object();
        SoftReference<Object> softReference= new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;
        System.gc();
        System.out.println("GC后=======================");
        System.out.println(softReference.get());  //有值

    }
    
    //-Xms5m Xmx5m -XX:+PrintGCDetails
    static void menory_lock_softRefe(){



            Object o1=new Object();
            SoftReference<Object> softReference=new SoftReference<>(o1);
        try {
            System.out.println(o1);
            System.out.println(softReference);
            o1=null;
            Byte[] bytes = new Byte[1024 * 1024 * 10];  //自动发生GC
        }catch (Throwable e){
                e.printStackTrace();
        }finally {
            System.out.println("GC后===================");
            System.out.println(o1);
            System.out.println(softReference.get());  //无值
        }





    }


}
