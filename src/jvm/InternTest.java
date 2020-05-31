package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/28-15:24

jdk1.7之后 包括1.7  常量池放在堆中  不在放在永久代上
*/

import java.util.ArrayList;

public class InternTest {


    public static void main(String[] args) {
        String s = new String("1");
        //通过字节码文件查看，创建了两个对象，一个string对象，一个"1" 的常量池对象
        s.intern();//因此这没有起作用

        String s2 = "1";

        System.out.println(s == s2);//false

        String s3 = new String("1") + new String("1");
        //这并没有产生 "11"字符串常量
        s3.intern();//这会在 字符串常量中产生"11"，并且其地址指向 s3

        String s4 = "11";  //因为字符串常量中已有 "11"  因此s4相当于间接 指向s3因此s3=s4相等

        System.out.println(s3 == s4); //true

    }
}
