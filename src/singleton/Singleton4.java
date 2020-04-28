package singleton;/*
@author : Administrator
@create : 2020-04-2020/4/28-13:21

*/
//饱汉式 单例模式     线程不安全
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){};
    public Singleton4 getInstance(){
        if(null == instance){
            instance = new Singleton4();
        }
        return  instance;
    }



}
