package edu.guilford;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CarDriver {
    public static void main(String[] args) {
        //instantiating the scanner and random objects
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many cars do you want to generate? ");
        int numCars = scanner.nextInt();
        //creating an array of cars with the size of numCars and filling it with random cars
        Car[] cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            cars[i] = new Car();
        }

        System.out.println("Unsorted Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();

        // Selection Sort (O(n^2))
        Car[] selectionSortedCars = Arrays.copyOf(cars, numCars);
        long startTime = System.nanoTime();
        for (int i = 0; i < selectionSortedCars.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < selectionSortedCars.length; j++) {
                if (selectionSortedCars[j].getPrice() < selectionSortedCars[minIndex].getPrice()) {
                    minIndex = j;
                }
            }
            // swap the cars
            Car temp = selectionSortedCars[i];
            selectionSortedCars[i] = selectionSortedCars[minIndex];
            selectionSortedCars[minIndex] = temp;
        }
        long selectionSortTime = System.nanoTime() - startTime;
        System.out.println("Selection Sorted Cars:");
        for (Car car : selectionSortedCars) {
            System.out.println(car+"\n");
        }
        System.out.println("Selection Sort Time: " + selectionSortTime + " nanoseconds");
     
       
    }

    
}