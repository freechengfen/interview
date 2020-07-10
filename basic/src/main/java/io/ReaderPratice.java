package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-0:09

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderPratice {


    public static void main(String[] args) throws IOException {
        File file = new File("aa.txt");

        FileReader fileReader = new FileReader(file);


        int read ;
        while((read= fileReader.read()) != -1){
            System.out.print((char)read);  //char 强转的字符
        }


    }
}
