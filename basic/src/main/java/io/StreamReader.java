package io;/*
@author : Administrator
@create : 2020-07-2020/7/12-0:11
inputStreamReader   字节流转换为字符流
OutputStreamWriter   字符流转换为字节流


还有ObjectInputStream DataInputStream   注意读取的顺序 依次读取
*/

import java.io.*;

public class StreamReader {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("aa.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("aa3.txt");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            char[] chars=new char[5];
            int read;
            while((read = inputStreamReader.read(chars))!=-1){
                outputStreamWriter.write(chars,0,read);
            }
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
