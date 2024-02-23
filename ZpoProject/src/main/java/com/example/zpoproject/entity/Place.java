package com.example.zpoproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hangar_id")
    private Hangar hangar;

    private double area;
    private boolean available;
    private double monthlyFee;

    @OneToMany(mappedBy = "place")
    private List<Reservation> reservations;

}
