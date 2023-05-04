package edu.guilford;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class CarDriver {
    public static void main(String[] args) {
        // instantiating the scanner and random objects
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many cars do you want to generate? ");
        int numCars = scanner.nextInt();
        // creating an array of cars with the size of numCars and filling it with random
        // cars
        Car[] cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            cars[i] = new Car();
        }

        System.out.println("Unsorted Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();

        //we want to shuffle the cars so that they are in a random order
        //before we sort them
        for (int i = 0; i < cars.length; i++) {
            int randomIndex = rand.nextInt(cars.length);
            Car temp = cars[i];
            cars[i] = cars[randomIndex];
            cars[randomIndex] = temp;
        }

        // add a O(n2) sorting algorithm here
        //tehen print out the time it took to sort
        long startTime = System.nanoTime();
        for (int i = 0; i < cars.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[j].getPrice() < cars[minIndex].getPrice()) {
                    minIndex = j;
                }
            }
            Car temp = cars[i];
            cars[i] = cars[minIndex];
            cars[minIndex] = temp;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Selection Sort Time: " + duration + " nanoseconds");
        System.out.println("Sorted Cars:");
        for (Car car : cars) {
            //System.out.println(car);
        }
        System.out.println();

        // add a O(nlogn) sorting algorithm here
        //tehen print out the time it took to sort
        startTime = System.nanoTime();
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getPrice() - car2.getPrice();
            }
        });
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge Sort Time: " + duration + " nanoseconds");
        System.out.println("Sorted Cars:");
        for (Car car : cars) {
            //System.out.println(car);
        }
        System.out.println();

        // add a O(n) sorting algorithm here
        //tehen print out the time it took to sort
        startTime = System.nanoTime();
        int maxPrice = 0;
        for (Car car : cars) {
            if (car.getPrice() > maxPrice) {
                maxPrice = car.getPrice();
            }
        }
        int[] prices = new int[maxPrice + 1];
        for (Car car : cars) {
            prices[car.getPrice()]++;
        }
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[i]; j++) {
                cars[index] = new Car();
                index++;
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Counting Sort Time: " + duration + " nanoseconds");
        System.out.println("Sorted Cars:");
        for (Car car : cars) {
           // System.out.println(car);
        }
        System.out.println();

        // add a O(n2) sorting algorithm here
        //tehen print out the time it took to sort
        startTime = System.nanoTime();
        for (int i = 1; i < cars.length; i++) {
            Car key = cars[i];
            int j = i - 1;
            while (j >= 0 && cars[j].getPrice() > key.getPrice()) {
                cars[j + 1] = cars[j];
                j--;
            }
            cars[j + 1] = key;
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion Sort Time: " + duration + " nanoseconds");
        System.out.println("Sorted Cars:");
        for (Car car : cars) {
           // System.out.println(car);
        }
        System.out.println();

        //now, we want to search for a car with a specific price
        //using the binary search algorithm
        System.out.print("What price car do you want to search for? ");
        int price = scanner.nextInt();
        //we want to sort the cars by price first
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getPrice() - car2.getPrice();
            }
        });
        //now, we want to search for the car
        startTime = System.nanoTime();
        int low = 0;
        int high = cars.length - 1;
        int mid = (low + high) / 2;
        while (low <= high && cars[mid].getPrice() != price) {
            if (price < cars[mid].getPrice()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        if (low > high) {
            System.out.println("Car not found");
        } else {
            System.out.println("Car found at index " + mid);
            System.out.println(cars[mid]);
        }
        System.out.println("Binary Search Time: " + duration + " nanoseconds");
        
        //now, we want to search for a car with a specific year
        //using the linear search algorithm
        System.out.print("What year car do you want to search for? ");
        int year = scanner.nextInt();
        //now, we want to search for the car
        startTime = System.nanoTime();
        int indexe = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getYear() == year) {
                indexe = i;
                break;
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        if (indexe == -1) {
            System.out.println("Car not found");
        } else {
            System.out.println("Car found at index " + indexe);
            System.out.println(cars[indexe]);
        }
        System.out.println("Linear Search Time: " + duration + " nanoseconds");

        scanner.close();

   
    }

}
