package vechicleSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import vechicleSystem.dao.DataBaseOperations;
import vechicleSystem.models.Vehicle;

public class BikeController implements  Vehicles {
  @Autowired
  public void setDataBaseOperations(DataBaseOperations dataBaseOperations) {
    this.dataBaseOperations = dataBaseOperations;
  }

  DataBaseOperations dataBaseOperations;

    @Override
    public void save(Vehicle vehicle) {

    }
}
