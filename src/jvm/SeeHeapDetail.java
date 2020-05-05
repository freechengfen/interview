package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/5-17:25
 jconsole  jmap  jviusalvm
*/

public class SeeHeapDetail {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(10000);
        byte[]  bte = new byte[1024 * 1024 *10];
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(3000);


    }
}
