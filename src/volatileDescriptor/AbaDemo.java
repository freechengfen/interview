package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-18:28

*/

import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

class User{
    private int age;
    private int height;

    public User (int age,int height){
        this.age=age;
        this.height=height;
    }
    public int getAge(){
        return this.age;
    }

    public int getHeight(){
        return this.height;
    }




}

public class AbaDemo {
    static {
        userA = new User(12, 156);
        userB = new User(14, 180);
    }


        static  AtomicReference<User> userRefer=   new AtomicReference<User>();
        static User userA;
        static User userB;



    public static void main(String[] args) {
        solveABA();
    }


       public static void haveABA(){
           userRefer.set(userA);
           userRefer.compareAndSet(userA,userB);
           userRefer.compareAndSet(userB,userA);
           new Thread(()->{
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(userRefer.compareAndSet(userA, userB));
               System.out.println(userRefer.get());
           }).start();

       }

    public static void solveABA(){
        AtomicStampedReference<User> userAtomicStampRefer = new AtomicStampedReference<>(userA,100);

        int intialStamp=userAtomicStampRefer.getStamp();

        userAtomicStampRefer.compareAndSet(userA,userB,userAtomicStampRefer.getStamp(),userAtomicStampRefer.getStamp()+1);
        userAtomicStampRefer.compareAndSet(userB,userA,userAtomicStampRefer.getStamp(),userAtomicStampRefer.getStamp()+1);
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(userAtomicStampRefer.compareAndSet(userA, userB,intialStamp,intialStamp+1));
        }).start();

    }





}
