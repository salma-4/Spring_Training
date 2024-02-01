package com.DI;

import config.DatabaseOperation;

public class Car implements  Vehicle{
    DatabaseOperation databaseOperation;
    private String brand;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    //setter injection
    public void setDatabaseOperation(DatabaseOperation databaseOperation){
        this.databaseOperation=databaseOperation;

    }
    @Override
    public void saveDataIntoDB(Vehicle vehicle) {
      databaseOperation.save(vehicle);
    }
}
