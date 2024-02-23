package com.example.zpoproject.controller;

import com.example.zpoproject.entity.Hangar;
import com.example.zpoproject.entity.Reservation;
import com.example.zpoproject.repository.HangarRepository;
import com.example.zpoproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationRepository reservationRepository;


    private final HangarRepository hangarRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, HangarRepository hangarRepository) {
        this.reservationRepository = reservationRepository;
        this.hangarRepository = hangarRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        Hangar hangar = hangarRepository.findById(reservation.getPlace().getHangar().getId()).orElse(null);
        if (hangar != null && hangar.getMaxCapacity() > 0) {
            hangar.setMaxCapacity(hangar.getMaxCapacity() - 1);
            hangarRepository.save(hangar);
            return reservationRepository.save(reservation);
        } else {
            // obsłuż sytuację, kiedy nie ma dostępnych miejsc w hangarze
            return null;
        }
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setAirplane(reservationDetails.getAirplane());
            reservation.setPlace(reservationDetails.getPlace());
            reservation.setStartDate(reservationDetails.getStartDate());
            reservation.setEndDate(reservationDetails.getEndDate());
            reservation.setMonthlyFee(reservationDetails.getMonthlyFee());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            Hangar hangar = hangarRepository.findById(reservation.getPlace().getHangar().getId()).orElse(null);
            if (hangar != null) {
                hangar.setMaxCapacity(hangar.getMaxCapacity() + 1);
                hangarRepository.save(hangar);
            }
            reservationRepository.deleteById(id);
        }
    }
}

