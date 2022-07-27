package com.example.labspringboot.service;

import com.example.labspringboot.domain.Bill;
import com.example.labspringboot.domain.Fee;
import com.example.labspringboot.domain.Parkingslot;
import com.example.labspringboot.repository.ParkingslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingslotService {

    @Autowired
    private ParkingslotRepository repository;

    public List<Parkingslot> getAllParkingslots() { return repository.getAllParkingslots();
    }

    //From the stored procedure
    public Parkingslot getParkingslotById(int id) { return repository.getParkingslotById(id);
    }

    public List<?> getParkingslotInfo(Parkingslot parkingslot, String time) { return repository.getParkingslotInfo(
            parkingslot.getIdparkingslot(), time);
    }

    public List<Parkingslot> getSlotsByParking(int id) { return repository.getSlotsByParking(id);
    }

    //From the stored procedure
    public void insertParkingslotSP(Parkingslot parkingslot) { repository.insertParkingslotSP(parkingslot.getParking().getIdparking(),
            parkingslot.getTypevehicle().getIdtype(), parkingslot.getNumber(), parkingslot.getPreferentialslot());
    }

    //From the stored procedure
    public void updateParkingslotSP(Parkingslot parkingslot) { repository.updateParkingslotSP(parkingslot.getIdparkingslot(),
            parkingslot.getTypevehicle().getIdtype(), parkingslot.getPreferentialslot());
    }

    //From the stored procedure
    public void deleteParkingslotSP(int id) { repository.deleteParkingslotSP(id);
    }

    /*public List<Parkingslot> listAll() {
        return repository.findAll();
    }

    public void save(Parkingslot parkingslot) {
        repository.save(parkingslot);
    }

    public Parkingslot get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }*/

}
