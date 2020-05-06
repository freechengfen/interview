package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/6-16:55
jvm 堆内存  Runtime.getRuntime().maxMemory()/Runtime.getRuntime().totalMemory();

vm Option :-Xms512m  -Xmx512m  -XX:+PrintGCDetails
*/

import java.util.Random;
import java.util.UUID;

public class JvmParameter {

    public static void main(String[] args) {
        heaperror();


    }


     static  void showParameter(){
         long maxMemory = Runtime.getRuntime().maxMemory();
         long totalMemory = Runtime.getRuntime().totalMemory();
         System.out.println("MB "+maxMemory/1024/1024);
         System.out.println("MB "+totalMemory/1024/1024);
    }

    static void  heaperror(){
        String str="";
        while(true){
            str+=str+ new String(UUID.randomUUID().toString().substring(0,8));
            System.out.println(str);
        }

    }
}
