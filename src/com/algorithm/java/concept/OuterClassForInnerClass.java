package com.algorithm.java.concept;

public class OuterClassForInnerClass {
	private String outerClassVariable="outerVar";
	public void print(){
		System.out.println("in outer class");
	}
	class Inner{
		private String innerClassVariable="innerVar";
		public void print(){
			System.out.println("print outer variable -->"+outerClassVariable+", "+innerClassVariable);
		}
	}
	public static void main(String[] args) {
		OuterClassForInnerClass outer = new OuterClassForInnerClass();
		Inner inner=outer.new Inner();
		inner.print();
	}
}
