package reflect;/*
@author : Administrator
@create : 2020-07-2020/7/14-0:05

properties 使用配置文件
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProper {

    public static void main(String[] args) throws IOException {
        //方式一：
        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");  //注意相对路径指向
//        properties.load(fileInputStream);
//        System.out.println("user :"+properties.getProperty("user"));

        //方式二
        InputStream resourceAsStream = ReadProper.class.getClassLoader().getResourceAsStream("jdbc4.properties");
        properties.load(resourceAsStream);
        System.out.println("user :"+properties.getProperty("user"));  //注意相对路径


    }
}
