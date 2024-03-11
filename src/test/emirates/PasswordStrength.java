package test.emirates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrength {

    public static void main(String[] args) {
        findPasswordStrength("aNup56&Mehta@");//strong
        findPasswordStrength("aN3$p");//weak
        findPasswordStrength("aN3pM5hTa");//medium
        findPasswordStrength("aN3pM5hTa1988");//medium
        findPasswordStrength("aN3pM5hTa##1988");//strong
    }

    public static void findPasswordStrength(String inputPassword) {
        if (inputPassword.length() < 6) {
            System.out.println("invalid");
        } else if (inputPassword.length() < 8) {
            System.out.println("weak");
        } else {
            String minimumCriteria = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    //+ "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,25}$";



            Pattern p = Pattern.compile(minimumCriteria);
            Matcher m = p.matcher(inputPassword);

            if (!m.matches()) {
                System.out.println("weak");
            } else {
                String minimumCriteriaWithoutEnd = minimumCriteria.substring(0, minimumCriteria.length() - 1);
                String strongPasswordCriteria = minimumCriteriaWithoutEnd + "(?=.*[@#$%^&+=])(?=\\S+$).{8,25}$" ;
                String strongPasswordCriteria2 = "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,25}$";

                p = Pattern.compile(strongPasswordCriteria);
                m = p.matcher(inputPassword);
                if (m.matches() && inputPassword.length() >= 10) {
                    System.out.println("strong");
                } else {
                    System.out.println("medium");
                }
            }

        }
    }
}
