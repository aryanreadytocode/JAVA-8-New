package main.thread_tutorial;

public class DeadlockExample extends Thread{

    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);
    }
    @Override
    public void run() {
        b.d2(a);
    }

    public static void main(String[] args) {
       DeadlockExample deadlockExample = new DeadlockExample();
       deadlockExample.m1();
    }
}

class A {
    public synchronized void d1(B b) {
        System.out.println("Thread 1 start execution of d1()");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ie) {}
        System.out.println("Thread trying to call B's last() method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside A's last() method");
    }
}

class B {
    public synchronized void d2(A a) {
        System.out.println("Thread 2 start execution of d2()");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ie) {}
        System.out.println("Thread trying to call A's last() method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Inside B's last() method");
    }
}
