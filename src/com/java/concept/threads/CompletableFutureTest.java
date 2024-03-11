package com.java.concept.threads;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //usingSimpleThreads();
        //usingCompletableFutures();
        usingCompletableFuturesThenCombine();

    }

    private static void usingCompletableFuturesThenCombine(){
        System.out.println("Starting Completable Future Example..");
        CompletableFuture<String> basePrep = CompletableFuture.supplyAsync(() -> {
            System.out.println("Preparing Base");
            return "Base Ready";
        });
        CompletableFuture<String> topPrep = CompletableFuture.supplyAsync(() -> {
            System.out.println("Preparing Top");
            return "Toppings Ready";
        });
        CompletableFuture<String> foodPrep = basePrep.thenCombine(topPrep,(baseResponse,topResponse) ->{
            System.out.println("Top and Base are::"+baseResponse+":"+topResponse);
            return "Pizza Ready";
        });
        CompletableFuture<String> foodServe = foodPrep.thenCompose(food ->{
            System.out.println("Serving Food");
            return CompletableFuture.supplyAsync(()->"Food Served");
        });
        CompletableFuture<String> order = foodServe.thenApply(orderComplete -> "Oder Completed..");
        try{
            System.out.println(order.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Reason to use Completable future is to avoid Main thread to become the co-ordinator,
    //result of one CFuture is passed to another CFuture without main thread interferring
    private static void usingCompletableFutures() throws InterruptedException {

            Person sharedObjPerson = new Person("Anup", "", "");
            Task task1 = new Task("task1", sharedObjPerson);
            CompletableFuture<Person> cf1 = CompletableFuture.supplyAsync(() -> task1.call());
            CompletableFuture<Person> cf2 = cf1.thenApplyAsync((personObj) -> new Task("task2",personObj).call())
                    //thenAccept uses consumer meaning it doesnt get response whereas applyAsync can get a response
                    //as it accepts function
            .whenComplete((personObj,error)-> System.out.println("All task completed !!"));

            while(!cf2.isDone()){
                Thread.sleep(1000);
            }



        System.out.println("Exiting main method ");
    }

    private static void usingSimpleThreads() throws InterruptedException {
        Person sharedObjPerson = new Person("Anup", "", "");
        Thread t1 = new Thread(new Task("task1", sharedObjPerson), "Thread-1");
        t1.start();

        t1.join();
        System.out.println("In main method to continue further processing !");
        Thread.sleep(1000);

        Thread t2 = new Thread(new Task("task2", sharedObjPerson), "Thread-2");
        t2.start();
    }


}

class Task implements Runnable, Callable<Person> {

    private String taskName;

    private Person person;

    public Task(String taskName, Person person) {
        this.taskName = taskName;
        this.person = person;
    }


    @Override
    public void run() {

        try {
            System.out.println("Starting " + taskName + " processing @ " + Calendar.getInstance().getTime());
            Thread.sleep(2000);
            person.prevWorkedBy = person.workedBy;
            person.workedBy = Thread.currentThread().getName();
            System.out.println(taskName + " completed  for person -->" + person + " @ " + Calendar.getInstance().getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person call() {
        try {
            System.out.println("Starting call() method " + taskName + " processing @ " + Calendar.getInstance().getTime());
            Thread.sleep(2000);
            person.prevWorkedBy = person.workedBy;
            person.workedBy = Thread.currentThread().getName();
            System.out.println(taskName + " completed  for person -->" + person + " @ " + Calendar.getInstance().getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return person;
    }
}

class Person {
    private String name;
    public String workedBy;
    public String prevWorkedBy;

    public Person(String name, String workedBy, String prevWorkedBy) {
        this.name = name;
        this.workedBy = workedBy;
        this.prevWorkedBy = prevWorkedBy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", workedBy='" + workedBy + '\'' +
                ", prevWorkedBy='" + prevWorkedBy + '\'' +
                '}';
    }
}
