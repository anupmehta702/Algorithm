package com.java.concept.immutabilityAndSingleton;



public  enum TryEnum {

    EAST("0"),
    WEST("180"),
    NORTH("90"),
    SOUTH("270");

    public String degree;

    TryEnum(String degree) {
        this.degree = degree;
    }



    @Override
    public String toString() {
        return "TryEnum{" +
                "degree='" + degree + '\'' +
                '}';
    }
}

class TestTryEnum{
    public static void main(String[] args) {
        System.out.println("Values -->"+TryEnum.values());
        for(TryEnum te : TryEnum.values()){
            System.out.println(te.degree);
        }
    }
}