package com.example.zpoproject.controller;

import com.example.zpoproject.entity.Airplane;
import com.example.zpoproject.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airplane getAirplaneById(@PathVariable Long id) {
        return airplaneRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @PutMapping("/{id}")
    public Airplane updateAirplane(@PathVariable Long id, @RequestBody Airplane airplaneDetails) {
        Airplane airplane = airplaneRepository.findById(id).orElse(null);
        if (airplane != null) {
            airplane.setRegistration(airplaneDetails.getRegistration());
            airplane.setModel(airplaneDetails.getModel());
            airplane.setWingspan(airplaneDetails.getWingspan());
            airplane.setLength(airplaneDetails.getLength());
            airplane.setOwner(airplaneDetails.getOwner());
            return airplaneRepository.save(airplane);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneRepository.deleteById(id);
    }
}

