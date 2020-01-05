package com.java.concept.hashmap;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import static java.lang.System.gc;

public class WeakHashMapImplementation {

    public static void main(String[] args) {
        Map<Test,String> weakMap = new WeakHashMap<>();
        Test t1 = new Test(1);
        Test t2 = new Test(2);
        weakMap.put(t1,"one");
        weakMap.put(t2,"two");
        System.out.println("Intially -->");
        Set<Map.Entry<Test,String>> set = weakMap.entrySet();
        set.stream().forEach((e)-> System.out.println("["+e.getKey()+","+e.getValue()+"]"));
        t1 = null;
        System.out.println("After nullifying t1 -->");
        set.stream().forEach((e)-> System.out.println("["+e.getKey()+","+e.getValue()+"]"));
        gc();
        System.out.println("After GC !");
        set.stream().forEach((e)-> System.out.println("["+e.getKey()+","+e.getValue()+"]"));
    }
}
class Test{
    Integer id;
    public Test(Integer id){
        this.id= id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}
/*
Output --
Intially -->
[Test{id=1},one]
[Test{id=2},two]
After nullifying t1 -->
[Test{id=1},one]
[Test{id=2},two]
After GC !
[Test{id=2},two]

 */