package com.algorithm.java.concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAboutHashmap {

	 
	
	public static void main(String[] args) {
		TestForHashmap h1 =new TestForHashmap();
		TestForHashmap h2 =new TestForHashmap();
	
		
		Map<TestForHashmap, String> map=new HashMap<>();
		map.put(h1, "h1");
		map.put(h2, "h2");
		
		for (Map.Entry<TestForHashmap, String> entry : map.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
		}
		System.out.println("value h1 is present -->"+map.containsValue("h1"));
		System.out.println("value h2 is present -->"+map.containsValue("h2"));
		
		System.out.println("key h1 is present -->"+map.containsKey(h1));
		System.out.println("key h2 is present -->"+map.containsKey(h2));
		
		System.out.println("value for  h1 is present -->"+map.get(h1));
		System.out.println("value for h2 is present -->"+map.get(h2));
		
	}
}
class TestForHashmap{
	public String name="Hello";
	public boolean equals(Object obj){
		return this.name.equals(((TestForHashmap)obj).name);
	}
}