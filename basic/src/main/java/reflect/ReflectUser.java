package reflect;/*
@author : Administrator
@create : 2020-07-2020/7/14-23:13

*/

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUser {


    public static void main(String[] args) throws Exception {

//        attributeUse();
        methodUse();

    }


    //属性调用
    public static void attributeUse() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class sonClass = Son.class;
        Son son =(Son) sonClass.newInstance();
        Field hu = sonClass.getDeclaredField("lastName");
        hu.setAccessible(true);
        hu.set(son,"hu");
        System.out.println(son);

    }

    //方法调用
    public static void methodUse() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class sonClass = Son.class;
        Son son =(Son) sonClass.newInstance();
        Method method = sonClass.getDeclaredMethod("show");
        method.setAccessible(true);
        method.invoke(son);

    }





}
