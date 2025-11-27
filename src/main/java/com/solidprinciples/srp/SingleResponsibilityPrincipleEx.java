package com.solidprinciples.srp;

public class SingleResponsibilityPrincipleEx {

    public static void main(String args[]) {

        Vehicle firstVehicle = new Vehicle("Toyota",  "Camry");
        firstVehicle.printDetails();
    }

}

/*
Every class in Java should have a single job to do. To be precise,
there should only be one reason to change a class.
Here’s an example of a Java class that does not follow the
single responsibility principle (SRP):
 */
class VehicleNotSRP {
    public void printDetails() {}
    public void calculateValue() {}
    public void addVehicleToDB() {}
}


/*
The Vehicle class has three separate responsibilities: reporting, calculation,
and database. By applying SRP, we can separate the above class into three classes with
separate responsibilities.

Consider the following code example that fulfills the SRP.
The Vehicle class is only responsible for printing the details of the Vehicle:
 */

class Vehicle {
    private String make;
    private String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Print vehicle details
    public void printDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
    }
}