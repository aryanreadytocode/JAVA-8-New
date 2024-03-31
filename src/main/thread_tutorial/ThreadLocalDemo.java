package main.thread_tutorial;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        System.out.println(tl.get());
        tl.set("Anu");
        System.out.println(tl.get());
        tl.remove();;
        System.out.println(tl.get());
    }
}
///

class ThreadLocalDemo1 {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal() {
            public Object initialValue () {
                return "abc";
            }
        };
        System.out.println(tl.get());
        tl.set("aryan");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());

    }
}

//
class CustomerThread extends Thread {
    static int customerId = 0;
    private static ThreadLocal tl = new ThreadLocal() {
        protected Integer initialValue() {
            return ++customerId;
        }
    };
    CustomerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " executing with customerId: "+ tl.get());
    }
}

class ThreadLocalDemo2 {
    public static void main(String[] args) {
        CustomerThread c1 = new CustomerThread("Customer Thread-1");
        CustomerThread c2 = new CustomerThread("Customer Thread-2");
        CustomerThread c3 = new CustomerThread("Customer Thread-3");
        CustomerThread c4 = new CustomerThread("Customer Thread-4");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
