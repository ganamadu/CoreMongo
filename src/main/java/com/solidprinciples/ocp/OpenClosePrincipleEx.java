package com.solidprinciples.ocp;

public class OpenClosePrincipleEx {

    public static void main(String[] args) {

        Car car = new Car(25000.0);

        Truck truck = new Truck(35000.0);

        System.out.println("Car value: "+car.calculateValue());
        System.out.println("Truck value: "+truck.calculateValue());

    }

}


/*
Software entities (e.g., classes, modules, functions) should be open for an extension,
but closed for modification.
Consider the below method of the class VehicleCalculations:

public class VehicleCalculations {
    public double calculateValue(Vehicle v) {
        if (v instanceof Car) {
            return v.getValue() * 0.8;
            if (v instanceof Bike) {
                return v.getValue() * 0.5;

            }
        }
    }
}
Suppose we now want to add another subclass called Truck.
We would have to modify the above class by adding another if statement,
which goes against the Open-Closed Principle.
A better approach would be for the subclasses Car and Truck to override the
calculateValue method:
 */

// Make the Vehicle class as parent for Car and Truck subclasses
class Vehicle {
    private double value;

    public Vehicle(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    // Calculate vehicle value (base implementation)
    public double calculateValue() {
        return value; // No depreciation by default
    }
}

// Subclass Car
class Car extends Vehicle {

    public Car(double value) {
        super(value);
    }

    // Override calculateValue for cars (80% depreciation)
    @Override
    public double calculateValue() {
        return super.calculateValue() * 0.8; // Apply 80% depreciation
    }
}

// Subclass Truck
class Truck extends Vehicle {

    public Truck(double value) {
        super(value);
    }

    // Override calculateValue for trucks (90% depreciation)
    @Override
    public double calculateValue() {
        return super.calculateValue() * 0.9; // Apply 90% depreciation
    }
}

