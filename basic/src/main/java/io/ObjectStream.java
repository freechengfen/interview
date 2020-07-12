package io;/*
@author : Administrator
@create : 2020-07-2020/7/12-23:23

序列化 是在传输过程中把对象 转换成流流的方式来传播，也就是把java对象映射成可以的传输对象
        像OjectInputStream 可以读取对象并把其序列化
        大部分场景中 java对象都是以json的格式来传播  json可以序列化

在java对象序列化 注意点：
1. 实现serializable 接口
2.对象的属性如果是其他对象的话 也得序列化接口
3.显示的指定 serilizeUId 值 ，防止 序列化过后 对象发生改变，导致反序列化失败
4.如果有不想序列化的属性 可以使用static\transient 修饰

*/

import java.io.*;

public class ObjectStream {


    public static void main(String[] args) {
        outputObjectStream();
        inputObjectStream();


    }


    public static void inputObjectStream() {
        Person person = null;
        ObjectInputStream objectInputStream =null;
        FileInputStream fileInputStream =null;
        try {
             fileInputStream = new FileInputStream(new File("obj.dat"));

             objectInputStream = new ObjectInputStream(fileInputStream);

            person = (Person)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(person);

    }

    public static void outputObjectStream() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("obj.dat"));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new Person("freechengfen", 18));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {

                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Person implements Serializable {

    private String name;

    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}