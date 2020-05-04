package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-18:07

抛出异常   add remove element
特殊值     offer(false)   poll(null)    peek
阻塞            put(阻塞)    take(阻塞)   不可用
超时       offer(e.time,unit)  poll(time,unit)

 b
*/



import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


class ShareResourece{

    private  volatile   boolean flag = true;
    private  BlockingQueue bqueue;
    private AtomicInteger atomInt = new AtomicInteger();

    ShareResourece(BlockingQueue bquere){
       this.bqueue=bquere;
        System.out.println("添加的阻塞队列是\t"+bquere.getClass().getName());
    }

    public void prod() throws InterruptedException {
        boolean result;
        int data;
        while(flag){
            data=atomInt.incrementAndGet();
            result= bqueue.offer(data,2, TimeUnit.SECONDS);
           if(result){
               System.out.println("添加数据成功"+data);
           }
            Thread.sleep(1000);
        }

        System.out.println("停止添加数据");
    }

    public void consume() throws InterruptedException {
        Object poll;
        while(flag){
            poll = bqueue.poll(2, TimeUnit.SECONDS);
            if( poll==null ){
                System.out.println("获取数据结束");
                return;
            }else{
                System.out.println("获取数据是"+poll);
            }
        }

    }

    void stop(){
        this.flag=false;
    }

}

public class BlockingQueDemo {


    public static void main(String[] args) throws InterruptedException {
        ShareResourece shareResourece = new ShareResourece(new ArrayBlockingQueue(1));
            new Thread(()->{
                try {
                    shareResourece.prod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        new Thread(()->{
            try {
                shareResourece.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        Thread.sleep(5000);
        shareResourece.stop();
    }




}
