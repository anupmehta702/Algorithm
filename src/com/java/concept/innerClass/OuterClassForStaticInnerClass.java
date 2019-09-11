package com.java.concept.innerClass;

public  class OuterClassForStaticInnerClass {
	
	static String outerStaticVariable="OuterVariable";
	String nonStaticOuterVariable="outerNonStaticVariable";
	
	static void printOuter(){
		System.out.println("Inside outer class -->"+outerStaticVariable);
	}

	public static class Inner{
		 String innerStaticVariable="innerVariable";
		 void print(){
			System.out.println("Inside static inner class "+outerStaticVariable);
			printOuter();
		}
	}
	public static void main(String[] args) {
		Inner inner =new Inner();
		inner.print();
		System.out.println("-->"+inner.innerStaticVariable);
	}
}
