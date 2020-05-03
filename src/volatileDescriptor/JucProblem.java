package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/3-21:16

1.collections的synchronize的方法
2.copyOnWriteArraylist

*/

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class JucProblem {


    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();

        new CopyOnWriteArraySet<>();
        CopyOnWriteArrayList arrayList2= new CopyOnWriteArrayList<>();
        List<String> strings = Collections.synchronizedList(arrayList);

        for (int i = 1; i <4 ; i++) {
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0,8));
                arrayList2.add(UUID.randomUUID().toString().substring(0,8));
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.asList(strings));
        System.out.println(Arrays.asList(arrayList2));


    }

}
