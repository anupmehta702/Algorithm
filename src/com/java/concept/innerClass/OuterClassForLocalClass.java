package com.java.concept.innerClass;

public class OuterClassForLocalClass {
 private String outerVar="Outer";
 
 public void print(){
	 final String methodVar="method var";
	  class Local{
		  
		 public void print(){
			 System.out.println("printing outer var from local class-->"+outerVar);
			 System.out.println("printing member var from local class-->"+methodVar);
		 }
	 }
//	  methodVar="cannot change this value";
	  Local local = new Local();
	  local.print();
 }
 public static void main(String[] args) {
	OuterClassForLocalClass outer =new OuterClassForLocalClass();
	outer.print();
}
	
	
}
