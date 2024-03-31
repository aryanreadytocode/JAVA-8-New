package main;

public class OverloadExample {

    public void m1(int i){
        System.out.println("int type argument");
    }
    public void m1(float f){
        System.out.println("float type argument");
    }

    public static void main(String [] args){

        OverloadExample t =new OverloadExample();
        t.m1(10);
        t.m1(10.5f);
        t.m1('a');
        t.m1(10l);
//        t.m1(10.5);
    }

}
