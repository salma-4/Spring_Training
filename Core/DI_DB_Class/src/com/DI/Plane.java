package com.DI;

import config.DatabaseOperation;

public class Plane implements  Vehicle{
    DatabaseOperation databaseOperation;
    String brand ;

    public Plane() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    //constructor injection


    public Plane(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    @Override
    public void saveDataIntoDB(Vehicle vehicle) {
        databaseOperation.save(vehicle);
    }
}
