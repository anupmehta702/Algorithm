package test.bnymelon;

/* We are working for a train company writing an application to find the best empty seats in train cars.
We are looking for the best empty seats, these are the ones that are surrounded by other empty seats (front, side, and back).
Each car has a total of 10 seats, distributed in five rows, labeled A - E. Moreover, rows are divided into two columns, labeled 1 or 2.

Car:     001               027               457
Side:  1     2           1     2           1     2
     -----------       -----------       -----------
   A |[X]   [X]|     A |[X]   [X]|     A |[_]*  [_]|
   B |[X]   [X]|     B |[X]   [X]|     B |[_]   [X]|
   C |[_]   [_]|     C |[X]   [X]|     C |[X]   [X]| <-- Seat 457-C-2
   D |[_]   [X]|     D |[X]   [X]|     D |[_]   [_]|
   E |[_]* *[_]|     E |[_]   [_]|     E |[_]* *[_]|
     -----------       -----------       -----------
[X]  is a booked seat
[_]  is an empty seat
[_]* is an empty seat that is one of the best

Each ticket contains the number of a car (three digits), followed by a letter identifying the row, followed by the column's number:

       001-A-1           027-A-1           457-C-1
       001-A-2           027-A-2           457-C-2
       001-B-1           027-B-1
       001-B-2           027-B-2
                         027-C-1
                         027-C-2
                         027-D-1
                         027-D-2


Given a collection of sold tickets, write a function that returns the number of best empty seats left in cars.

Examples:
tickets_1 = ['457-C-1', '027-C-1', '027-C-2', '001-A-1', '001-A-2', '001-B-1', '001-B-2', '027-A-1', '027-A-2', '027-B-1', '027-B-2', '027-D-1', '027-D-2', '457-C-2']
tickets_2 = ['001-A-1', '001-A-2', '001-B-1', '001-B-2', '001-C-1', '001-C-2', '001-D-1', '001-D-2', '001-E-1', '001-E-2']
tickets_3 = ['001-A-1', '001-A-2', '001-B-1', '027-A-1', '027-A-2', '027-B-1', '027-B-2', '027-C-1', '027-C-2', '027-D-1']
tickets_4 = ['001-A-1', '001-B-2', '001-C-1', '001-D-2', '001-E-1']
tickets_5 = []
tickets_6 = ['666-A-1', '666-B-1', '666-C-1', '666-D-1', '666-E-1', '999-A-1', '999-E-2']
tickets_7 = ['001-A-1', '002-B-2', '003-C-1', '100-C-2', '123-D-1', '555-D-2', '888-E-1']

best_seats(tickets_1) -> 8
best_seats(tickets_2) -> 0
best_seats(tickets_3) -> 6
best_seats(tickets_4) -> 0
best_seats(tickets_5) -> 0
best_seats(tickets_6) -> 4
best_seats(tickets_7) -> 44


Complexity variables:
T - number of tickets */


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] argv) {

        String[] tickets_1 = {"457-C-1", "027-C-1", "027-C-2", "001-A-1", "001-A-2", "001-B-1", "001-B-2", "027-A-1", "027-A-2", "027-B-1", "027-B-2", "027-D-1", "027-D-2", "457-C-2"};
        String[] tickets_2 = {"001-A-1", "001-A-2", "001-B-1", "001-B-2", "001-C-1", "001-C-2", "001-D-1", "001-D-2", "001-E-1", "001-E-2"};
        String[] tickets_3 = {"001-A-1", "001-A-2", "001-B-1", "027-A-1", "027-A-2", "027-B-1", "027-B-2", "027-C-1", "027-C-2", "027-D-1"};
        String[] tickets_4 = {"001-A-1", "001-B-2", "001-C-1", "001-D-2", "001-E-1"};
        String[] tickets_5 = {};
        String[] tickets_6 = {"666-A-1", "666-B-1", "666-C-1", "666-D-1", "666-E-1", "999-A-1", "999-E-2"};
        String[] tickets_7 = {"001-A-1", "002-B-2", "003-C-1", "100-C-2", "123-D-1", "555-D-2", "888-E-1"};

        Train train = new Train();
        train.fillSeats(tickets_7);
        System.out.println(train.getTotalBestSeats());

    }
}

class Train {
    private Map<String, Car> cars = new HashMap<>();
    Map<String, Integer> stringToNumMap = new HashMap<>();


    public Train() {
        stringToNumMap.put("A", 0);
        stringToNumMap.put("B", 1);
        stringToNumMap.put("C", 2);
        stringToNumMap.put("D", 3);
        stringToNumMap.put("E", 4);
    }

    //001-A-1
    public void fillSeats(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            fillSeats(inputArr[i]);
        }
    }

    public void fillSeats(String input) {
        String[] inputArr = input.split("-");
        //System.out.println("input-->"+inputArr[0]);
        Car respectiveCar = null;
        if (cars.get(inputArr[0]) != null) {
            respectiveCar = cars.get(inputArr[0]);
        } else {
            respectiveCar = new Car(inputArr[0]);
            cars.put(inputArr[0], respectiveCar);
        }
        int row = convertStringToNum(inputArr[1]);
        respectiveCar.fillSeat(row, Integer.valueOf(inputArr[2]) - 1);

    }

    public int getTotalBestSeats() {
        int totalBestSeats = 0;
        Integer total =cars.entrySet().stream()
                .map((entry)->entry.getValue().getBestSeatCount())
                .reduce(0,(a,b)->a+b);
        System.out.println("Total -->"+total+" totalBestSeats-->"+totalBestSeats);
        return totalBestSeats;
    }

    public int convertStringToNum(String input) {
        //TODO add validations
        return stringToNumMap.get(input);
    }
}

class Car {
    public String name = "";
    final int noOfRows = 5;
    final int noOfCols = 2;
    String[][] seats = new String[noOfRows][noOfCols];

    public Car(String name) {
        this.name = name;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                seats[i][j] = "_";
            }
        }
    }

    public void fillSeat(int row, int col) {
        seats[row][col] = "X";
    }

    public Integer getBestSeatCount() {
        Integer bestSeatCount = 0;
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if(seats[i][j] != "X") {
                    if (checkTopSeat(i, j) && checkBottomSeat(i, j)
                            && checkRightSeat(i, j) && checkLeftSeat(i, j)) {
                        seats[i][j] = "*";
                        bestSeatCount++;
                    }
                }
            }
        }

        return bestSeatCount;
    }

    public void printSeats() {
        System.out.println("printing seats -->");
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkTopSeat(int row, int col) {
        if (row == 0) {
            return true;
        } else {
            if (seats[row - 1][col] != "X") {
                return true;
            }
        }
        return false;

    }

    private boolean checkBottomSeat(int row, int col) {
        if (row == (noOfRows - 1)) {
            return true;
        } else {
            if (seats[row + 1][col] != "X") {
                return true;
            }
        }
        return false;

    }

    private boolean checkLeftSeat(int row, int col) {
        if (col == 0) {
            return true;
        } else {
            if (seats[row][col - 1] != "X") {
                return true;
            }
        }
        return false;

    }

    private boolean checkRightSeat(int row, int col) {
        if (col == (noOfCols - 1)) {
            return true;
        } else {
            if (seats[row][col + 1] != "X") {
                return true;
            }
        }
        return false;

    }


}




