package main.thread_tutorial;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolOrExecutorDemo {
    public static void main(String[] args) {
        PrintJob[] jobs = {new PrintJob("Raj"), new PrintJob("Aryan"), new PrintJob("Rahul"),
                new PrintJob("Rajan"), new PrintJob("Vir"), new PrintJob("Aman")};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (PrintJob job: jobs) {
            executorService.submit(job);
        }
        executorService.shutdown();
    }
}

class PrintJob implements Runnable {
    String name;
    PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+ " Job started by Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        }catch (InterruptedException ie) {}
        System.out.println(name+ " Job completed by Thread "+Thread.currentThread().getName());
    }
}
