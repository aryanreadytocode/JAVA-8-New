package main;

public class MultipleCatchBlock {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        Object ob = new Object();
        try{
            int a[]=new int[5];
            a[5]=30/0;
            System.out.println(a[10]);
        }
        finally {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}
