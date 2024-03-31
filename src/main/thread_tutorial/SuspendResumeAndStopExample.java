package main.thread_tutorial;

public class SuspendResumeAndStopExample {

    public static void main(String[] args) {
        Thread11 t11 = new Thread11();
        t11.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("stop called");
//        t11.stop();
        System.out.println(t11.getName()+" state: "+t11.getState());
        System.out.println("suspend called");
        t11.suspend();
        System.out.println(t11.getName()+" state: "+t11.getState());
        System.out.println("resume called");
        t11.resume();
        System.out.println(t11.getName()+" state: "+t11.getState());


    }
}

class Thread11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println("run :"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
