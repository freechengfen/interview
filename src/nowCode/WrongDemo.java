package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/5-21:37

*/

public class WrongDemo {

    String deviceName;

    void getDeviceName(String a){
        a="232";
    }
    getDeviceName(deviceName);   //编译时错误  没有把他当成 调用方法 而是当成一个定义方法，调用方法在其他方法内部调用


}
