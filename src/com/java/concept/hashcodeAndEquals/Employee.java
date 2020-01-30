package com.java.concept.hashcodeAndEquals;

import java.util.Objects;

public class Employee {
    int empId;
    String name ;
    String city ;

    public Employee(int empId, String name, String city) {
        this.empId = empId;
        this.name = name;
        this.city = city;
    }

    public boolean customEquals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass()!= obj.getClass())return false;
        Employee other = (Employee) obj;
        if(!city.equals(other.city)) return false;
        if(!name.equals(other.name)) return false;
        if(empId != other.empId) return false;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empId != employee.empId) return false;
        if (!name.equals(employee.name)) return false;
        return city.equals(employee.city);
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + name.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    public boolean equalsJava7Onwards(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(name, employee.name) &&
                Objects.equals(city, employee.city);
        //Object.equals(Object a, Object b) -> return (a == b) || (a != null && a.equals(b));
    }

    public int hashCodeJava7Onwards() {
        return Objects.hash(empId, name, city);
    }
    /*
    int hash(Object... values) {
        return Arrays.hashCode(values);
    }
    public static int hashCode(Object a[]) {
        if (a == null)
            return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
    }
    */

}
