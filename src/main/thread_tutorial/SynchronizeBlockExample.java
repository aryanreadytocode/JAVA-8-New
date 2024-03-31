package main.thread_tutorial;

import java.util.Random;

public class SynchronizeBlockExample {
    public static void main(String[] args) {
        Cricket c= new Cricket();
        MyThread8 t1 = new MyThread8("Virat", c);
        MyThread8 t2 = new MyThread8("Gambhir", c);
        t1.start();
        t2.start();
    }
}

class Cricket {

    public void doBat(String batsmanName) {
        System.out.println("Get Ready for bat");
        System.out.println("Wear helmet");
        int count = 0;
        int run = 0;
        Random random = new Random();
        synchronized (this) {
            System.out.println("Walk to the pitch");
            System.out.println(batsmanName+" playing");
           while (count <6) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               run = random.nextInt(7);
               System.out.println("Scored "+run);
               count++;
           }
        }
    }
}

class MyThread8 extends Thread {
    String playerName;
    private Cricket c;
    MyThread8(String name, Cricket c) {
        playerName = name;
        this.c = c;
    }

    @Override
    public void run() {
        c.doBat(playerName);
    }
}