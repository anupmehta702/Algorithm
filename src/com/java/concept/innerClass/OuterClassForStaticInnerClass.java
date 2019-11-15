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
		OuterClassForStaticInnerClass.Inner inner =new OuterClassForStaticInnerClass.Inner();
		inner.print();
		System.out.println("-->"+inner.innerStaticVariable);
	}
}
/*Output
Inside static inner class OuterVariable
Inside outer class -->OuterVariable
-->innerVariable
 */