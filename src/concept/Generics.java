package concept;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {

//	    checkSuper();
	//	printExtendedFruitList();
	//	printSuperBananaList();
		compareSuperExtends();
		
	}
	public static void compareSuperExtends(){
		List<Banana> bananaList=new ArrayList<>();
		List<AsianBanana> asianBananaList=new ArrayList<>();
		List<Fruit> fruitList = new ArrayList<>();

		List<? super Banana> superBananaList = bananaList;
		//superBananaList=asianBananaList; Not allowed
		superBananaList = fruitList;
		List<? extends Banana> extendBananaList = bananaList;
		//extendBananaList=fruitList; //not allowed
		extendBananaList=asianBananaList;

		superBananaList.add(new Banana());
		//superBananaList.add(new Fruit());
		superBananaList.add(new AsianBanana());

		/* Not allowed
		extendBananaList.add(new AsianBanana());
		extendBananaList.add(new Fruit());
		extendBananaList.add(new Banana());*/
		for(Banana fruit : extendBananaList){
			System.out.println(fruit);
		}
		for(Object banana : superBananaList){
			System.out.println(banana);

		}
	}
	public static void printSuperBananaList(){
		List<Banana> bananaList=new ArrayList<>();
		bananaList.add(new Banana());
		List<AsianBanana> asianBananaList=new ArrayList<>();
		bananaList.add(new AsianBanana());

		List<Fruit> fruitList = new ArrayList<>();
		fruitList.add(new Banana());
		fruitList.add(new Mango());
		fruitList.add(new Fruit());

		List<? super Banana> superBananaList = bananaList;

		System.out.println("----In Super List (only containing banana)-----");
		for (Object obj : superBananaList) {
			Banana banana =(Banana) obj;
			banana.print();
		}

		superBananaList=fruitList;

		superBananaList.add(new AsianBanana());

		System.out.println("----In Super List(now containing fruit)-----");
		for (Object obj : superBananaList) {
				Fruit banana =(Fruit) obj;
				banana.print();
		}
		//superBananaList.add(new Fruit());

		superBananaList = new ArrayList<Fruit>();
		superBananaList = new ArrayList<Banana>();
		//superBananaList = new ArrayList<AsianBanana>();//not allowed

	}
	
	public static void printExtendedFruitList(){
		List<Apple> appleList = new ArrayList<>();

		List<AsianApple> asianAppleList = new ArrayList<>();
		asianAppleList.add(new AsianApple());

		List<Fruit> fruitList = new ArrayList<>();

		List<? extends Apple>extendsAppleList =new ArrayList<>();
		//extendsAppleList.add(new AsianApple()); throws exception
		//extendsAppleList.add(new Apple());// throws exception
		extendsAppleList = appleList;
		extendsAppleList = asianAppleList;
		//extendsAppleList = fruitList; //throws exception

		System.out.println("----In Extends List(for extend)-----");
		for (Fruit fruit : extendsAppleList) {
			fruit.print();
		}
		//extendsFruitList.add(new Mango());

		extendsAppleList = new ArrayList<Apple>();
		extendsAppleList = new ArrayList<AsianApple>();
		//extendsAppleList = new ArrayList<Fruit>();//not allowed
	}
	
	public static void checkSuper(){
		List<Apple> appleList=new ArrayList<>();
		List<? super Apple> appleBasket =appleList;
		//appleBasket.add(new Fruit());
		appleBasket.add(new AsianApple());
		appleBasket.add(new Apple());
		for(Object obj : appleBasket){
			Fruit fruit= (Fruit)obj;
			fruit.print();
		}
		
		
		List<Fruit> fruitList=new ArrayList<>();
		fruitList.add(new Mango());
		fruitList.add(new Banana());
		List<? super Apple> fruitBasket =fruitList;
		for(Object obj : fruitBasket){
			Fruit fruit= (Fruit)obj;
			fruit.print();
		}
		
	}

}
