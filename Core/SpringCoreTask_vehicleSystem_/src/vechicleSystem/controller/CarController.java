package vechicleSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import vechicleSystem.dao.DataBaseOperations;
import vechicleSystem.models.Vehicle;

public class CarController implements  Vehicles{
    @Autowired
    DataBaseOperations dataBaseOperations;
    @Override
    public void save(Vehicle vehicle) {
dataBaseOperations.save(vehicle);
    }
}
