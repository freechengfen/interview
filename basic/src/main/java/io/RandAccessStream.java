package io;/*
@author : Administrator
@create : 2020-07-2020/7/12-23:59

RandomAccessFile 可以当输入流 也可以当输出流 以mode构造函数指定
1.RandomAccessFile  可以覆盖的  seek 方法指定位置 然后在指定位置去写
   这个可以类似于迅雷下载的断点续传，记录下下载位置，然后之后继续下载
   利用这一特性 可以去在某一位置插入值  把后面的数值记录下来，然后重会覆盖点，去write
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandAccessStream {


    public static void main(String[] args) {
        insertChar(3L);


    }

    //hello 覆盖演示
    public static void  helloRandAccFile(){
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile("random.txt", "rw");
            rw.seek(5);
            rw.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rw != null) {
                    rw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //插入字符
    public static void insertChar(Long pos) {
        RandomAccessFile readFile = null;
        try {
            readFile = new RandomAccessFile("hello.txt", "rw");
            readFile.seek(pos);
            byte[] bytes = new byte[1024];
            int read1;
            StringBuilder stringBuilder = new StringBuilder("xyz");
            while ((read1 = readFile.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, read1));
            }
            readFile.seek(pos);
            readFile.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readFile != null) {
                try {
                    readFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
