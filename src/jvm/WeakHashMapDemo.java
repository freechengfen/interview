package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/7-15:33

*/

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

//1.weakhashmap   gc之后为空  2.引用队列  在gc之后，会放在引用队列里

public class WeakHashMapDemo {
    public static void main(String[] args) {
//        hashMapDemo();
//        weakhashMapDemo();
        referQue();
    }

    private static  void hashMapDemo(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        Integer integer = new Integer("1");
        hashMap.put(integer,"hashmap");
        System.out.println(hashMap);
        integer =null;
        System.gc();
        System.out.println("GC后========================");
        System.out.println(hashMap);

    }

    private static  void weakhashMapDemo(){

        WeakHashMap<Integer, String> weakhashMap = new WeakHashMap<>();
        Integer integer = new Integer("2");
        weakhashMap.put(integer,"WeakHashMap");
        System.out.println(weakhashMap);
        integer =null;
        System.gc();
        System.out.println("GC后========================");
        System.out.println(weakhashMap+"hashmap大小" +weakhashMap.size());  //为weakhashmap 被清空

    }


    private static  void referQue()  {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println("gc前，referenceQueue :"+referenceQueue.poll());

        o1=null;
        System.gc();
        try {
            Thread.sleep(500);  //必须要睡一下，要不然引用队列获取不到
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("gc后，referenceQueue :"+referenceQueue.poll());
    }
}
