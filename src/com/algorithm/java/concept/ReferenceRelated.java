package com.algorithm.java.concept;

import java.lang.ref.*;

public class ReferenceRelated {
	
	public static void main(String[] args) throws InterruptedException {
		weakReference();
		phantomReference();
	}
	
	public static void phantomReference() throws InterruptedException{
		ReferenceRelated outer =new ReferenceRelated();
		Counter counter =  outer.new Counter();
		
		ReferenceQueue<Counter> queue=new ReferenceQueue<>();
		PhantomReference<Counter> phantomRef=new PhantomReference<Counter>(counter, queue);
		counter=null;
		System.out.println(phantomRef.isEnqueued());
		
		System.gc();
		
		System.out.println(phantomRef.isEnqueued());
		
	}
	
	public static void weakReference() throws InterruptedException{
		ReferenceRelated outer =new ReferenceRelated();
		Counter counter =  outer.new Counter();
		
		WeakReference<Counter> weakRef=new WeakReference<ReferenceRelated.Counter>(counter);
		counter=null;
		System.out.println("counter -->"+weakRef.get().counter);
		
		System.gc();
		Thread.sleep(10);
		
		if(weakRef.get()!= null){
			System.out.println("Not garbage collected !");
		}else{
			System.out.println("garbage collected !");
		}
		
		
	}

	class Counter{
		int counter=1;
		protected void finalize() throws Throwable{
		System.out.println("in finalize method !!");	
		}
	}
	
	
}
