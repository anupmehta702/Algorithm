package com.java.concept;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(10);
        System.out.println("Initial value -->"+ai.get());
        ai.set(100);//set() method is plain simple setter method ,no CAS
        if(!ai.compareAndSet(ai.get(),200)){
            System.out.println("Value not set yet ");
        }

        /*
        public final boolean compareAndSet(int expect, int update) {
            return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
        }
         */

        System.out.println("Updated value -->"+ai.get());
    }
}
/*output -->
Initial value -->10
Updated value -->200

other operations -
addAndGet() – Atomically adds the given value to the current value and returns new value after the addition.
getAndAdd() – Atomically adds the given value to the current value and returns old value.
incrementAndGet() – Atomically increments the current value by 1 and returns new value after the increment. It is equivalent to ++i operation.
getAndIncrement() – Atomically increment the current value and returns old value. It is equivalent to i++ operation.
decrementAndGet() – Atomically decrements the current value by 1 and returns new value after the decrement. It is equivalent to i- – operation.
getAndDecrement() – Atomically decrements the current value and returns old value. It is equivalent to – -i operation.

 */