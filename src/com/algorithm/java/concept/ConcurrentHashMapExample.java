package com.algorithm.java.concept;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	Map<String,String> chm=new ConcurrentHashMap<>();
	
	public void check(){
		chm.put("key1", "value1");
		chm.get("key1");
	}
	public static void main(String[] args) {
		ConcurrentHashMapExample example=new ConcurrentHashMapExample();
		example.check();
		
		 ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
	        premiumPhone.put("Apple", "iPhone6");
	        premiumPhone.put("HTC", "HTC one");
	        premiumPhone.put("Samsung","S6");
	        
	        Iterator<String>iterator = premiumPhone.keySet().iterator();
	        
	        while (iterator.hasNext())
	        {
	            System.out.println(premiumPhone.get(iterator.next()));
	            premiumPhone.put("Sony", "Xperia Z");
	        }
	        iterator = premiumPhone.keySet().iterator();
	        
	        while (iterator.hasNext())
	        {
	            System.out.println(premiumPhone.get(iterator.next()));
	        }
	        
	    
	}
}
