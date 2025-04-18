/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.uberlite;

/**
 *
 * @author Samantha Lorin
 */

class UberLiteApp {
    private String name;
    private String email;

    public UberLiteApp(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

// --- Driver Class ---
class Driver extends UberLiteApp {
    private double rating;
    private Vehicle vehicle;
    private boolean available;

    public Driver(String name, String email, Vehicle vehicle) {
        super(name, email);
        this.vehicle = vehicle;
        this.available = true;
        this.rating = 5.0;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public Vehicle getVehicle() { return vehicle; }
}

// --- Passenger Class ---
class Passenger extends UberLiteApp {
    private double balance;

    public Passenger(String name, String email, double balance) {
        super(name, email);
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}

// --- Abstract Vehicle Class ---
abstract class Vehicle {
    private String licensePlate;
    private String model;

    public Vehicle(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getModel() { return model; }
}

// --- Vehicle Types ---
class Car extends Vehicle {
    public Car(String licensePlate, String model) {
        super(licensePlate, model);
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate, String model) {
        super(licensePlate, model);
    }
}

class Scooter extends Vehicle {
    public Scooter(String licensePlate, String model) {
        super(licensePlate, model);
    }
}

// --- Pricing Strategy Pattern ---
abstract class PricingStrategy {
    public abstract double calculateFare(double distance);
}

class StandardPricing extends PricingStrategy {
    public double calculateFare(double distance) {
        return distance * 1.5;
    }
}

class SurgePricing extends PricingStrategy {
    public double calculateFare(double distance) {
        return distance * 2.5;
    }
}

// --- Ride Class ---
class Ride {
    private Driver driver;
    private Passenger passenger;
    private double distance;
    private double fare;

    public Ride(Driver driver, Passenger passenger, double distance) {
        this.driver = driver;
        this.passenger = passenger;
        this.distance = distance;
    }

    public void calculateFare(PricingStrategy strategy) {
        this.fare = strategy.calculateFare(distance);
    }

    public double getFare() {
        return fare;
    }
}

public class UberLite {


    public static void main(String[] args) {
         // Setup test data
        Car car = new Car("XYZ-987", "Tesla Model 3");
        Driver driver = new Driver("Liam", "liam@drive.com", car);
        Passenger passenger = new Passenger("Olivia", "olivia@ride.com", 75.0);

        Ride ride = new Ride(driver, passenger, 8.2); // 8.2 km ride
        PricingStrategy strategy = new StandardPricing();
        ride.calculateFare(strategy);

        // Output the result
        System.out.println("Driver: " + driver.getName());
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Vehicle: " + car.getModel());
        System.out.println("Distance: 8.2 km");
        System.out.println("Fare (Standard): $" + ride.getFare());
    }
}

