package vechicleSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import vechicleSystem.dao.DataBaseOperations;
import vechicleSystem.models.Vehicle;

public class PlaneController implements Vehicles{
    DataBaseOperations dataBaseOperations;



    @Autowired
    public PlaneController(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }


    @Override
    public void save(Vehicle vehicle) {
dataBaseOperations.save(vehicle);
    }
}
