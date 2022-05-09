import java.util.ArrayList;
import java.util.List;

public class Help {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Object[] array = list.toArray();
        int total = (int)array[0] + (int)array[1];
        System.out.println(total);
    }
}
 class Employee {
    protected int salary;
    protected String grade;
    Employee(int salary, String grade){
        this.salary = salary;
        this.grade = grade;
    }
    Employee(){
        //default constructor
    }

     public int getSalary() {
         return salary;
     }

     public void setSalary(int salary) {
         this.salary = salary;
     }

     public String getGrade() {
         return grade;
     }

     public void setGrade(String grade) {
         this.grade = grade;
     }
 }