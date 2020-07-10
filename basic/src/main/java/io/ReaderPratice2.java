package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-0:09
  复制
*/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderPratice2 {


    public static void main(String[] args)  {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File file = new File("aa.txt");
            File file1 = new File("aa1.txt");
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);

            char[] chars= new char[5];
            int read;
            while((read= fileReader.read(chars)) != -1){  //获取的数字放在chars数组中 每次读取五个
                fileWriter.write(chars,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
