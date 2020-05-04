package juc;/*
@author : Administrator
@create : 2020-05-2020/5/4-15:28

*/

public enum EnumDemo {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"韩"),SIX(6,"魏");

    private int code;
    private String name;

    public int getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }

     EnumDemo(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static  EnumDemo foreach(int code) {
        EnumDemo[] enumDemo = EnumDemo.values();
        for (EnumDemo demo : enumDemo) {
            if(code == demo.getCode()){
                return demo;
            }
        }
        return null;
    }
}
