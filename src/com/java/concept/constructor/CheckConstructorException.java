package com.java.concept.constructor;

import com.java.concept.Exception.UserCheckedException;

public class CheckConstructorException {
    public static void main(String[] args) {
        TestConstructor tc = null;
        try {
             tc = new TestConstructor();
        } catch (UserCheckedException e) {
            e.printStackTrace();
        }
        System.out.println("Value of tc -->"+tc);
    }
}
class TestConstructor{

    public TestConstructor() throws UserCheckedException {
        throw new UserCheckedException();
    }

}
//super() is automatically placed by java ,however if you have this() ,then it does not add super()
//also ,if default constructor is not present then you would haveto write it manually
/*Output
Value of tc -->null
com.java.concept.Exception.UserCheckedException
 */
