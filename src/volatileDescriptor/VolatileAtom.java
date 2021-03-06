package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-14:42
   volitile 没有原子性
     此例中  如果有原子性  结果会是20000  但是因为不能保证原子性  多个线程在赋值的时候会有重复赋值的情况发生
     因此不能保证结果是 20000

    保证原子性的解决  使用juc中 atomic 类  如 atommicInteger
*/

import java.util.concurrent.atomic.AtomicInteger;

class  Data{
     volatile int num=0;

     AtomicInteger atomicInteger=new AtomicInteger();

      void change(){
        this.num=20;
    }
    void add(){
        num++;
    }
   void atomAdd(){
          atomicInteger.getAndIncrement();
   }



}


public class VolatileAtom {

    public static void main(String[] args) {
        Data mydata = new Data();
        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                for (int j = 1; j <=2000 ; j++) {
                    mydata.add();
                    mydata.atomAdd();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){   //等待所有线程运行完    有gc/主线程
            Thread.yield();
        }
        System.out.println(mydata.num);
        System.out.println(mydata.atomicInteger);



    }


}
