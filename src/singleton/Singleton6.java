package singleton;/*
@author : Administrator
@create : 2020-04-2020/4/28-13:21

*/

import sun.security.jca.GetInstance;

//线程安全  饱汉式
public class Singleton6 {

    private Singleton6() {
    }

    private static class Inner {
        private static Singleton6 instance = new Singleton6();
    }

    public Singleton6 getInstance() {
        return Inner.instance;
    }

}
