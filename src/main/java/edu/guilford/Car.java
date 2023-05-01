package edu.guilford;

import java.util.Random;

public class Car {
    // attribute of the car
    private String make;
    private String model;
    private int year;
    private String color;
    private int price;

    // constructor for the car
    public Car() {
        // array of makes, models, and colors
        String[] makes = { "Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Mercedes-Benz", "Nissan", "Volkswagen",
                "Tesla", "Audi" };
        String[] models = { "Corolla", "Civic", "F-150", "Silverado", "3 Series", "E-Class", "Altima", "Jetta",
                "Model S", "A4" };
        String[] colors = { "Red", "Blue", "Green", "Yellow", "Black", "White", "Silver", "Gray" };
        Random rand = new Random();
        // randomizes the make, model, year, color, and price of the car
        this.make = makes[rand.nextInt(makes.length)];
        this.model = models[rand.nextInt(models.length)];
        this.year = rand.nextInt(25) + 1995;
        this.color = colors[rand.nextInt(colors.length)];
        this.price = rand.nextInt(20000) + 10000;
    }
    // getters for the car
    // we don't need setters because we don't want to change the attributes of the
    // car

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    // toString method for the car to print of the car's attributes
    @Override
    public String toString() {
        return year + " " + make + " " + model + ", " + color + ", $" + price;
    }

 
    }
