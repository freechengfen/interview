package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/5-21:37
   switch (exp){} xep 数据类型可以是 int byte short char enum string
*/

public class WrongDemo3 {


    public static void main(String[] args) {

        switch ("sadf") {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("default");
                break;
        }


    }

}

