package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-14:42
   volitile 可见性证明
   多个线程获取主线程中 变量副本时    当其中一个线程 中副本修改之后会通知其他线程   这种就是可见性
     此例中  就是当一个线程修改 Mydata.num 的值时   另一个线程也会得到通知
*/
class  Mydata{
     volatile int num=0;

      void change(){
        this.num=20;
    }

}


public class VolatileCanSee {

    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.change();
     },"a").start();

        while(mydata.num == 0){
            System.out.println("xunhuan");
        }
        System.out.println(mydata.num);


    }


}
