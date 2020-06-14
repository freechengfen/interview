package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/6-19:19

*/

public class Base {


    Base(int i){
        System.out.println("base:have constrctor");
    }

    public Base() {
        System.out.println("base:no constrctor");
    }
}

class Myover extends Base{
    Myover(int i){
        System.out.println("myover");
    }

    public static void main(String[] args) {
        Myover myover = new Myover(1);  //掉用父类的时候还是调用无参
    }


}
