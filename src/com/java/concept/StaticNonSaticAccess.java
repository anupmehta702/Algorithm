package com.java.concept;

interface CheckingStaticInterface{
	public final static int staticVarOfInterface=10;
	public int nonStaticVarOfInterface=20;

	public void nonStaticMethod();
}
public class StaticNonSaticAccess  implements CheckingStaticInterface{

	public static int staticVar =1;
	 public int nonStaticVar =10;
	 
	 public static void staticMethod(){
		 staticVar=10;
		 //nonStaticVar=20;//non static variable cannot be accessed by static variable
		 System.out.println("printing static variable of interface -->"
				 +CheckingStaticInterface.staticVarOfInterface
				 +" non static variable-->"
				 +CheckingStaticInterface.nonStaticVarOfInterface);
	 }
	 
	 public void nonStaticMethod(){
	 	staticVar=10;//nonStaticMethod can access Static variable
	 }
	 
	 public static void main(String[] args) {	
	 	CheckingStaticInterface obj = new StaticNonSaticAccess();
	 	obj.nonStaticMethod();
	 	staticMethod();
	}
	 	 
}
/* Output -
printing static variable of interface -->10 non static variable-->20
 */