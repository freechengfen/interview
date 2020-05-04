package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-14:42
   volitile    单例模式
   因为 new  VolatileSingleton（）；实际上是三步    memory=allocate()   insance=createInstacne  memory=insance
   当存在指令重排时 还是重复到22 行代码执行

*/

public class VolatileSingleton {

    private  volatile VolatileSingleton Instance ;

    private VolatileSingleton (){
        System.out.println("创建单例模式");
    };

    public  VolatileSingleton getInstace(){
        if(null == Instance){
            synchronized (VolatileSingleton.class){
                if(null == Instance){
                        Instance= new VolatileSingleton();
                }
            }
        }
        return   Instance;
    }

}
