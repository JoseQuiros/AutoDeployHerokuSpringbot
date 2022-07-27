package com.example.labspringboot.service;


import com.example.labspringboot.domain.Users;
import com.example.labspringboot.domain.Vehicle;
import com.example.labspringboot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<?> getAllVehicles() { return repository.getAllVehicles();
    }

    //From the stored procedure
    public Vehicle getVehicleById(int id) { return repository.getVehicleById(id);
    }

    public List<Vehicle> getVehicleByClient(int id) { return repository.getVehicleByClient(id);
    }

    //From the stored procedure
    public void insertVehicleSP(Vehicle vehicle) { repository.insertVehicleSP(vehicle.getType().getIdtype(),
            vehicle.getBrand(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getRegister(),
            vehicle.getDescription());
    }

    //From the stored procedure
    public void updateVehicleSP(Vehicle vehicle) { repository.updateVehicleSP(vehicle.getIdvehicle(), vehicle.getType().getIdtype(),
            vehicle.getBrand(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getRegister(),
            vehicle.getDescription());
    }

    //From the stored procedure
    public void deleteVehicleSP(int id) { repository.deleteVehicleSP(id);
    }

    /*public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public void save(Vehicle vehicle) {
        repository.save(vehicle);
    }

    public Vehicle get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }*/

}
