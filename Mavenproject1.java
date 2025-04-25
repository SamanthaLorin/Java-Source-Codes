/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
class Vehicle {
    private String brand, model;
    private double distance, fuel;

    public Vehicle(String brand, String model, double distance, double fuel) {
        this.brand = brand;
        this.model = model;
        this.distance = distance;
        this.fuel = fuel;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getDistance() { return distance; }
    public double getFuel() { return fuel; }

    public double Formula() {
        return fuel == 0 ? 0 : distance / fuel;
    }

    public void VehicleSummary() {
        System.out.println("Vehicle: " + brand + " " + model);
        System.out.println("Distance Traveled: " + distance + " km");
        System.out.printf("Fuel Efficiency: %.2f km/l\n\n",  Formula());
    }
}

class Car extends Vehicle {
    public Car(String brand, String model, double distance, double fuel) {
        super(brand, model, distance, fuel);
    }
}

class Bike extends Vehicle {
    public Bike(String brand, String model, double distance, double fuel) {
        super(brand, model, distance, fuel);
    }
}

class Truck extends Vehicle {
    public Truck(String brand, String model, double distance, double fuel) {
        super(brand, model, distance, fuel);
    }
}

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Vehicle car = inputVehicle(input, "Car", Car.class);
        Vehicle bike = inputVehicle(input, "Bike", Bike.class);
        Vehicle truck = inputVehicle(input, "Truck", Truck.class);

        System.out.println("\n--- Vehicle Summary ---");
        car.VehicleSummary();
        bike.VehicleSummary();
        truck.VehicleSummary();
    }

    static Vehicle inputVehicle(Scanner input, String type, Class<? extends Vehicle> vehicleClass) {
        System.out.println("\nEnter details for " + type + ":");
        System.out.print("Brand: ");
        String brand = input.next();
        System.out.print("Model: ");
        String model = input.next();
        System.out.print("Distance Traveled (km): ");
        double distance = input.nextDouble();
        System.out.print("Fuel Used (liters): ");
        double fuel = input.nextDouble();

        try {
            return vehicleClass.getConstructor(String.class, String.class, double.class, double.class)
                               .newInstance(brand, model, distance, fuel);
        } catch (Exception e) {
            System.out.println("Something went wrong with " + type);
            return null;
        }
    }
}