package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-0:09

*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderPratice1 {


    public static void main(String[] args) throws IOException {
        File file = new File("aa.txt");

        FileReader fileReader = new FileReader(file);


        char[] chars= new char[5];
        int read;
        while((read= fileReader.read(chars)) != -1){  //获取的数字放在chars数组中 每次读取五个
            System.out.print(new String(chars,0,read));  //char 强转的字符
        }


    }
}
