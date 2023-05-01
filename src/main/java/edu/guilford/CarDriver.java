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
            System.out.println(car + "\n");
        }
        System.out.println("Selection Sort Time: " + selectionSortTime + " nanoseconds");
        System.out.println();

        // merge sort
        Car[] mergeSortedCars = Arrays.copyOf(cars, numCars);
        startTime = System.nanoTime();
        mergeSort(mergeSortedCars, 0, mergeSortedCars.length - 1);
        long mergeSortTime = System.nanoTime() - startTime;
        System.out.println("Merge Sorted Cars:");
        for (Car car : mergeSortedCars) {
            System.out.println(car + "\n");
        }
        System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");
        System.out.println();

    }

    private static void mergeSort(Car[] mergeSortedCars, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(mergeSortedCars, i, mid);
            mergeSort(mergeSortedCars, mid + 1, j);
            merge(mergeSortedCars, i, mid, j);
        }
    }

    private static void merge(Car[] mergeSortedCars, int i, int mid, int j) {
        Car[] temp = new Car[j - i + 1];
        int left = i;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= j) {
            if (mergeSortedCars[left].getPrice() <= mergeSortedCars[right].getPrice()) {
                temp[k] = mergeSortedCars[left];
                left++;
            } else {
                temp[k] = mergeSortedCars[right];
                right++;
            }
            k++;
        }
        while (left <= mid) {
            temp[k] = mergeSortedCars[left];
            left++;
            k++;
        }
        while (right <= j) {
            temp[k] = mergeSortedCars[right];
            right++;
            k++;
        }
        for (k = 0; k < temp.length; k++) {
            mergeSortedCars[i + k] = temp[k];
        }

        //binary search
        int searchPrice = 15000;
        int index = binarySearch(mergeSortedCars, searchPrice);
        if (index == -1) {
            System.out.println("No car found with price $" + searchPrice);
        } else {
            System.out.println("Car found with price $" + searchPrice + ": " + mergeSortedCars[index]);
        }
    }

    private static int binarySearch(Car[] mergeSortedCars, int searchPrice) {
        int left = 0;
        int right = mergeSortedCars.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mergeSortedCars[mid].getPrice() == searchPrice) {
                return mid;
            } else if (mergeSortedCars[mid].getPrice() < searchPrice) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

}