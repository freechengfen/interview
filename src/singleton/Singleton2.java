package singleton;/*
@author : Administrator
@create : 2020-04-2020/4/28-13:07

*/

public class Singleton2 {
    private static  final Singleton2 instance;

    static {
        instance = new Singleton2();
    }
    private Singleton2(){}

}
