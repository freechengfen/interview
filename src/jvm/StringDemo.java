package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/5-18:54

*/

public class StringDemo {
    public static void main(String[] args) {
        String a="a";
        String b="b";
        String c="ab";
        String d= a+b;  //StringBuilder().apperd(a).append(b).toString() new String();
        System.out.println(c == d);


    }
}
