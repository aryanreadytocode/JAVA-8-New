package main.thread_tutorial;

import java.util.concurrent.*;

public class CallableAndFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable[] jobs = {new MyCallable(10), new MyCallable(20), new MyCallable(30), new MyCallable(40),
        new MyCallable(50), new MyCallable(60)};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (MyCallable job: jobs) {
            Future f = executorService.submit(job);
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
}
class MyCallable implements Callable {
    int num;
    MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+ " is responsible to find sum of first "+num+" numbers");
        int sum = 0;
        for (int i = 0; i<=num; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
