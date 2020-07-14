package reflect;/*
@author : Administrator
@create : 2020-07-2020/7/14-0:53

*/

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetGeneric {

    public static void main(String[] args) {
        //获取父类
        Class superclass = Son.class.getSuperclass();
        System.out.println(superclass);

        //获取带泛型的父类
        Type genericSuperclass = Son.class.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取父类的泛型
        Type genericSuperclass1 = Son.class.getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass1;

        System.out.println(type.getActualTypeArguments()[0].getTypeName());


    }
}
