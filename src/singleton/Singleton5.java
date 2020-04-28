package singleton;/*
@author : Administrator
@create : 2020-04-2020/4/28-13:21

*/
 //线程安全  饱汉式
public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){};
    public Singleton5 getInstance(){
        if(null == instance){
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return  instance;
    }



}
