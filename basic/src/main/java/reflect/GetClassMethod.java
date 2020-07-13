package reflect;/*
@author : Administrator
@create : 2020-07-2020/7/13-22:59

*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetClassMethod {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //方式一：
        Person person = new Person();
        Class aClass =  person.getClass();
        Constructor constructor = aClass.getConstructor(String.class, Integer.class);
        Field[] declaredFields = aClass.getDeclaredFields();
        Object personObject =(Person) constructor.newInstance("freechengfen", 18);
        System.out.println(personObject);
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if(declaredField.getType().getName().equals(String.class.getName())){
                declaredField.set(personObject,"gg");
            }

        }
        System.out.println(personObject);



    }
}
