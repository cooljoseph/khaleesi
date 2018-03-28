/*
 *  Copyright (c) 2018, Joseph Yoon
 *
 *  This file is licenced under a Creative Commons license:
 *  http://creativecommons.org/licenses/by/2.5/
 */

package com.kakaocorp.commerce.khaleesi;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadTests {
    @Test
    public void testInterrupt() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        CompletableFuture<String> completable = new CompletableFuture<>();
        Future<?> future = service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return; // remains uncompleted
                }
            }
            completable.complete("done");
        });

        Thread.sleep(2000);

        System.out.println(completable.get());

        // not atomic across the two
//        boolean cancelled = future.cancel(true);
//        if (cancelled)
//            completable.cancel(true); // may not have been cancelled if execution has already completed
//        if (completable.isCancelled()) {
//            System.out.println("cancelled");
//        } else if (completable.isCompletedExceptionally()) {
//            System.out.println("exception");
//        } else {
//            System.out.println("success");
//        }
//        service.shutdown();
    }
}
