package com.example.zpoproject.controller;

import com.example.zpoproject.entity.Hangar;
import com.example.zpoproject.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hangars")
public class HangarController {

    @Autowired
    private HangarRepository hangarRepository;

    @GetMapping
    public List<Hangar> getAllHangars() {
        return hangarRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hangar getHangarById(@PathVariable Long id) {
        return hangarRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Hangar createHangar(@RequestBody Hangar hangar) {
        return hangarRepository.save(hangar);
    }

    @PutMapping("/{id}")
    public Hangar updateHangar(@PathVariable Long id, @RequestBody Hangar hangarDetails) {
        Hangar hangar = hangarRepository.findById(id).orElse(null);
        if (hangar != null) {
            hangar.setName(hangarDetails.getName());
            hangar.setMaxCapacity(hangarDetails.getMaxCapacity());
            hangar.setArea(hangarDetails.getArea());
            return hangarRepository.save(hangar);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteHangar(@PathVariable Long id) {
        hangarRepository.deleteById(id);
    }
}

