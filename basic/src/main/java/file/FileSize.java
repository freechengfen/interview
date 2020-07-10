package file;/*
@author : Administrator
@create : 2020-07-2020/7/10-0:04

*/

import java.io.File;
import java.io.IOException;

public class FileSize {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\desktop\\ZTSHARE.zip");
        System.out.println(file.length());


    }
}
