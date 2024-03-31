package main;

public class CallByValue {

    int data = 50;
    void change(CallByValue callByValue) {
        callByValue.data = data+100;
    }

    public static void main(String[] args) {
        CallByValue callByValue = new CallByValue();
        System.out.println("Before change "+callByValue.data);
        callByValue.change(callByValue);
        System.out.println("After change "+callByValue.data);
    }
}


