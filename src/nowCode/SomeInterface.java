package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/5-21:27
接口中也可以定义 成员变量
*/

public interface SomeInterface {
     int a = 0;

    void add();

}


class dd implements SomeInterface {
    @Override
    public void add() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        SomeInterface d = new dd();
        d.add();
    }




}