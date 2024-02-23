package com.example.zpoproject.controller;

import com.example.zpoproject.entity.Place;
import com.example.zpoproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Place getPlaceById(@PathVariable Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        Place place = placeRepository.findById(id).orElse(null);
        if (place != null) {
            place.setHangar(placeDetails.getHangar());
            place.setArea(placeDetails.getArea());
            place.setAvailable(placeDetails.isAvailable());
            return placeRepository.save(place);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeRepository.deleteById(id);
    }
}

