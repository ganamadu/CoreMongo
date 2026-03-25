package com.javaconceptoftheday;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelSteamEx {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        /*IntStream.range(0,100000)
                .boxed()
                .parallel()
                .peek(val -> System.out.println(val+": "+Thread.currentThread().getName()))
                .reduce((x,y)->x+2*y)
                .orElse(0);*/


        Callable<Integer> task = () -> IntStream.range(0,100000)
                .boxed()
                .parallel()
                .peek(val -> System.out.println(val+": "+Thread.currentThread().getName()))
                .reduce((x,y)->x+2*y)
                .orElse(0);

        ForkJoinPool pool = new ForkJoinPool(8);
        int result = pool.submit(task).get();
        System.out.println(result);

    }

}
