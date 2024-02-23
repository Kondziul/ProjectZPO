package com.example.zpoproject.controller;

import com.example.zpoproject.entity.Owner;
import com.example.zpoproject.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner != null) {
            owner.setFirstName(ownerDetails.getFirstName());
            owner.setLastName(ownerDetails.getLastName());
            owner.setDateOfBirth(ownerDetails.getDateOfBirth());
            owner.setAddress(ownerDetails.getAddress());
            return ownerRepository.save(owner);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
    }
}

