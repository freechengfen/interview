package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/5-21:37
   覆写函数可以抛出更少的异常，或者抛出对应异常的子类
*/

public class WrongDemo2 {


    int a;
    protected  final int  b=7;

}

class child1 extends  WrongDemo2{

    public static void main(String[] args) {
        child1 child1 = new child1();
        System.out.println(child1.a);
    }
}
