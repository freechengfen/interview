package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-0:35

图片的复制
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream1 {

    public static void main(String[] args) {
        FileInputStream  fileInputStream =null;
        FileOutputStream fileOutStream =null;
        try {
            File src = new File("1.jpg");
            File des = new File("2.jpg");

            fileInputStream = new FileInputStream(src);
            fileOutStream = new FileOutputStream(des);

            byte[] bytes=new byte[5];
            int read ;
            while( (read=fileInputStream.read(bytes))!=-1){
                fileOutStream.write(bytes,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileOutStream != null){
                try {
                    fileOutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }
}
