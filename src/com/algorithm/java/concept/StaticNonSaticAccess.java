package com.algorithm.java.concept;

public class StaticNonSaticAccess  implements CheckingStaticInterface{

	public static int staticVar =1;
	 public int nonStaticVar =10;
	 
	 public static void staticMethod(){
		 staticVar=10;
		 System.out.println("printing static variable of interface -->"+CheckingStaticInterface.staticVarOfInterface
				 +" non static variable-->"+CheckingStaticInterface.nonStaticVarOfInterface);
	 }
	 
	 public void nonStaticMethod(){
		 
	 }
	 
	 public static void main(String[] args) {	
		 CheckingStaticInterface obj = new StaticNonSaticAccess();
	}
	 	 
}
interface CheckingStaticInterface{
	public final static int staticVarOfInterface=10;
	public int nonStaticVarOfInterface=20;
	
	public void nonStaticMethod();
}
