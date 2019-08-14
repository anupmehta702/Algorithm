package com.algorithm.java.concept;

public class Fruit {
 int type=1;
 public void print(){
	 System.out.println("In Fruit !!");
 }
}
class Banana extends Fruit{
	public void print(){
		System.out.println("In Banana");
	}	
}
class AsianBanana extends Banana{
	public void print(){
		System.out.println("In Asian Banana");
	}

}

class Mango extends Fruit{
	public void print(){
		System.out.println("In Mango");
	}
	
}
class Apple extends Fruit{
	public void print(){
		System.out.println("In Apple");
	}
	
}
class AsianApple extends Apple{
	public void print(){
		System.out.println("In AsianApple");
	}
	
}

