package com.example.zpoproject.entity;

import com.example.zpoproject.entity.Airplane;
import com.example.zpoproject.entity.Place;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    @JsonBackReference
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    private Date startDate;
    private Date endDate;
    private double monthlyFee;

}
