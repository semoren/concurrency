package com.sermo.concurrency.example.atomic;

import com.sermo.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {


    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    /**
     * volatile 非static
     */
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)){
            log.info("success1: {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)){
            log.info("success2: {}", example5.getCount());
        }else {
            log.info("failed: {}", example5.getCount());
        }
    }

}
