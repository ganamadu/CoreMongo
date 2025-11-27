package com.javaconceptoftheday.threads;

public class SynchronizedExample {

    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName()+" ---> Count: "+ count);
    }

    public int getCount() {
        return count;
    }

    public static void main(String args[]) throws InterruptedException {

        SynchronizedExample ex = new SynchronizedExample();

        Runnable task = ex::increment;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();;
        t2.join();
        t3.join();

        System.out.println("Final Count: "+ex.getCount());

    }

}
