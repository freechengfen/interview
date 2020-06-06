package nowCode;/*
@author : Administrator
@create : 2020-06-2020/6/5-23:48
  默认类型   10 默认是int
  10.0 默认是double 类型
  指定 long\float型的   后面 添加l/f
*/


public class DefautlNum {


    public static void main(String[] args) {
        float a = 1.2f;
        float d = 10;  //因为10 是整数  所以没报错
        //float  e=10.0; // 报错
        // long l=10.0;  //默认小数是 double 需要cast long
        //int i=a;   //float 赋值给啊   需要cast
    }
}
