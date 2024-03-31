package main.thread_tutorial;

public class StaticSynchronizedExample {

    public static void main(String arg[])
    {

        MyThread7 t1=new MyThread7("Dhoni");
        MyThread7 t2=new MyThread7("Yuvaraj");
        t1.start();
        t2.start();
    }
}

class Display1 {

    public static synchronized void wish(String name) {
        for (int i = 0; i<3; i++) {
            System.out.println("Good Morning");
            System.out.println(name);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ie) {}
        }
    }
}
class MyThread7 extends Thread {
    Display1 d;
    String name;
    MyThread7(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Display1.wish(name);
    }
}
