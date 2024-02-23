package com.example.zpoproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Hangar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int maxCapacity;
    private double area;


    @OneToMany(mappedBy = "hangar")
    @JsonIgnore
    private List<Airplane> airplanes = new ArrayList<>();

}
