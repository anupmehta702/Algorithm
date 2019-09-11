package com.java.concept;

import java.lang.ref.*;

public class ReferenceRelated {

    public static void main(String[] args) throws InterruptedException {
        weakReference();
        phantomReference();
    }

    public static void phantomReference() throws InterruptedException {
        Counter counter = new Counter();
        ReferenceQueue<Counter> queue = new ReferenceQueue<>();
        PhantomReference<Counter> phantomRef = new PhantomReference<Counter>(counter, queue);
        counter = null;
        System.out.println("IS phantom Reference enqueued ? " + phantomRef.isEnqueued());

        System.gc();

        System.out.println("Garbage collection called for phantom Reference");
        System.out.println("Is phantom Reference enqueued ?" + phantomRef.isEnqueued());

    }

    public static void weakReference() throws InterruptedException {
        Counter counter = new Counter();

        WeakReference<Counter> weakRef = new WeakReference<Counter>(counter);
        counter = null;
        System.out.println("can refer to the counter once it is nullified through weak reference  -->" + weakRef.get().counter);

        System.gc();

        System.out.println("Garbage collection called for weak reference!");

        if (weakRef.get() != null) {
            System.out.println("Not garbage collected !");
        } else {
            System.out.println("garbage collected ! Weak reference get eagerly garbage collected");
        }


    }

}

class Counter {
    int counter = 1;

    protected void finalize() throws Throwable {
        System.out.println("in finalize method !!");
    }
}

/*Out put
can refer to the counter once it is nullified through weak reference  -->1
Garbage collection called for weak reference!
garbage collected ! Weak reference get eagerly garbage collected
in finalize method !!
IS phantom Reference enqueued ? false
Garbage collection called for phantom Reference
in finalize method !!
Is phantom Reference enqueued ?false

 */
