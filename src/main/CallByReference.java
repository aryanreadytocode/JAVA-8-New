package main;

public class CallByReference {

    public static void main(String[] args) {
        Operation op = new Operation();
        System.out.println("before change"+op.data);
        op.change(op);
        System.out.println("after change "+op.data);
    }
}
/** This class is used to verify the call by value in java
 * This means java support only call by value
 * If you try to call method by value and try to update the value
 * it will get affected that particular method only*/
class Operation {
    int data = 50;
    void change(Operation operation) {
        operation.data = operation.data + 50;

        CharSequence s = new String("Aryan");

        System.out.println(s);
    }

}
