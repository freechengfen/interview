package reflect;/*
@author : Administrator
@create : 2020-07-2020/7/14-0:52

*/

public class Son extends Parent {

    private String lastName;
    private int age;

    private Son(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    public Son() {
    }



    private void show(){
        System.out.println("show  a little");
    }

    @Override
    public String toString() {
        return "Son{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
