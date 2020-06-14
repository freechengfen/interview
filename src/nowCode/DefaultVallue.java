package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/6-18:10

*/

public class DefaultVallue {



    private int num;
    private double d;
    private String s;

    public static void main(String[] args) {
        DefaultVallue defaultVallue = new DefaultVallue();
        System.out.println(defaultVallue.num);  //默认值是 0
        System.out.println(defaultVallue.d);    //默认值是 0.0
        System.out.println(defaultVallue.s);    //默认值是 null;
    }



}
