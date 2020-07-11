package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-23:02

*/

import java.io.*;

public class Buffer {


    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File srcFile = new File("1.jpg");
            File desFile = new File("3.jpg");

            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(desFile); //可以添加 true 表示append 而不是覆盖


            bufferedInputStream = new BufferedInputStream(fileInputStream);   //buffer构造器上放的是 stream
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int size;
            while((size = bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,size);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedOutputStream !=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedInputStream!=null){

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
