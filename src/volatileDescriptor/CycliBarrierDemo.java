package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/4-15:55

*/

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐七颗龙珠");
        });
            for (int i = 1; i <=7 ; i++) {
                final  int temp =i;
            new Thread(()->{
                System.out.println("集齐第"+temp+"龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }



    }

}
