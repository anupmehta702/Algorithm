package java.concept.innerClass;



import java.concept.innerClass.OuterClassForInnerClass.Inner;


//import concept.ClassForStaticInnerClass.Inner;

public  class  Test<T extends String> {
		public T mark;
	
	public static void main(String[] args) {
		Test<String> t=new Test<>();
		t.check123(new String("anup"));
		Test.check999(t);
//		Inner inner =new Inner();
//		System.out.println("Print varibale-->"+Inner.innerStaticVariable);
//		inner.print();
		OuterClassForInnerClass outer = new OuterClassForInnerClass();
		Inner inner = outer.new Inner();
		inner.print();
	}
	
	public <T extends String> void  check123(T mark1){
	
	}
	
	public static void  check999(Test<? super String> mark22){
		
	}
	
}
