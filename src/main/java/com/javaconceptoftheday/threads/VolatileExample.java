package com.javaconceptoftheday.threads;

public class VolatileExample {

    private volatile boolean running = true;


    public void startTask() {
        while (running) {
            System.out.println("Task running....");
        }

        System.out.println("Task stopped!");

    }

    public void stopTask() {
        running = false; // Visible immediately to other thread
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileExample ex = new VolatileExample();

        Thread worker = new Thread(ex::startTask);
        worker.start();;

        Thread.sleep(2000);

        System.out.println("Requesting stop.....");

        ex.stopTask();


    }



}
