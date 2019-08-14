public class Sample {

    public void method(Object object){
        System.out.println("Object");
    }
    public void method (String string){
        System.out.println("String");
    }
    public static void main(String[] args) {
        Sample a = new Sample();
        a.method(1);
        int z=8;
        System.out.println(z/=z--);
    }

    public void buzzFizz(String[] inputArr){
        for (String input : inputArr) {
            int inputInt = Integer.parseInt(input);
            if (inputInt < 1) {
                System.out.println(inputInt);
                return;
            }
            for (int i = 1; i <= inputInt; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}
