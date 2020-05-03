package volatileDescriptor;/*
@author : Administrator
@create : 2020-05-2020/5/4-0:00

*/

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {


    private volatile HashMap<String,String> map= new HashMap<String,String>();  //此处添加volatile 是利用可见性

    private ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();

     public void get(String key){
         rwlock.readLock().lock();
         try {
               map.get(key);
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             rwlock.readLock().unlock();
         }
    };

     public  void put(String key,String value){
         rwlock.writeLock().lock();
         try {
             map.put(key,value);
         }catch (Exception e){
                e.printStackTrace();
         }finally {
             rwlock.writeLock().unlock();
         }


    }

    public  void  clear(){
         map.clear();
    }





}
