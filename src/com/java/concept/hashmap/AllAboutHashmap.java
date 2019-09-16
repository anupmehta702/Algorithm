package com.java.concept.hashmap;

import java.util.*;

public class AllAboutHashmap {

	public static void main(String[] args) {
		TestForHashmap h1 =new TestForHashmap();
		TestForHashmap h2 =new TestForHashmap();
		TestForHashmap h3 =new TestForHashmap();

		Map<TestForHashmap, String> treeMap=new TreeMap<>();

		Map<TestForHashmap, String> map=new HashMap<>();
		map.put(h1, "h1");
		map.put(h2, "h2");

		for (Map.Entry<TestForHashmap, String> entry : map.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
			//map.put(h3,"h3"); this throws ConcurrentHashMap exception
		}
		Iterator<Map.Entry<TestForHashmap,String>> itr= map.entrySet().iterator();


		System.out.println("value h1 is present -->"+map.containsValue("h1"));
		System.out.println("value h2 is present -->"+map.containsValue("h2"));
		
		System.out.println("key h1 is present -->"+map.containsKey(h1));
		System.out.println("key h2 is present -->"+map.containsKey(h2));
		
		System.out.println("value for  h1 is present -->"+map.get(h1));
		System.out.println("value for h2 is present -->"+map.get(h2));

		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		for(int input :intList){
			System.out.println("Printing input -"+input);
			//intList.add(4); // this throws COncurrentModificationException ,since it internally uses iterator
		}
		for(int i=0;i<intList.size();i++){
			System.out.println("Printing input -"+intList.get(i));
			if(!intList.contains(4))//this conndition is imp or else it would go in infinte loop
				intList.add(4);
		}


	}
}
class TestForHashmap{
	public String name="Hello";
	public boolean equals(Object obj){
		return this.name.equals(((TestForHashmap)obj).name);
	}
}

