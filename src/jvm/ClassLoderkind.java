package jvm;/*
@author : Administrator
@create : 2020-05-2020/5/1-19:49

*/
//获取几种类的加载器

/*
bootStrap  classloader是c/c++ 写的  因此不能java代码不能获取到   用来加载java核心库
 扩展类加载器  和 系统类加载器(应用程序类加载器)  都是继承于classloader
 扩展类加载器 加载 ext文件夹下的类名
 自定义类获取都都是系统类加载器
*/

/*
自定义类加载器的应用场景 防止其他人根据字节码文件进行反编译  可以添加解密功能
自定义类的加载器  可以继承classloader 重写 findClass 方法
也可以继承urlClassloader方法*/

/*双亲委派机制
看上一级是否加载  具体到例子中就是   首先是系统类加载器  询问 扩展类加载器   扩展类加载器询问引导类加在器
引导类加载器(不加载)  ---> 扩展类加载器(不加载)--->系统类加载器

优势： 防止类的重复加载
       保护核心代码不被篡改   比如： 自己自定义 java.lang.String 类  如果没有双亲委派机制   那么会加载自定义的String类 这就破坏了核心类的完整性

*/


public class ClassLoderkind {


    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  //系统类加载器  sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader extClassloader = systemClassLoader.getParent();
        System.out.println(extClassloader);   //扩展类加载器  sun.misc.Launcher$ExtClassLoader@1b6d3586

        ClassLoader bootstraploader = extClassloader.getParent();
        System.out.println(bootstraploader);  // 引导类加载器  null


        ClassLoader defineClassloader = ClassLoderkind.class.getClassLoader();
        System.out.println(ClassLoderkind.class.getClassLoader());   //sun.misc.Launcher$AppClassLoader@18b4aac2   等于系统类加载器

        ClassLoader coreClassloader = String.class.getClassLoader();
        System.out.println(coreClassloader);   //null   核心类的加载器是引导类加载器

    }



}
