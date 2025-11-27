package com.javaconceptoftheday.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
       int value = count.incrementAndGet();
       System.out.println(Thread.currentThread().getName()+" ---> Count: "+value);
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerExample ex = new AtomicIntegerExample();

        Runnable task = ex::increment;

        Thread[] threads = new Thread[10];

        for(int i=0; i<10; i++) {
            threads[i] = new Thread(task, "Thread-"+i);
            threads[i].start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println("Final Count: "+ex.count.get());



    }

}
