package com.example.zpoproject.entity;

import com.example.zpoproject.entity.Address;
import com.example.zpoproject.entity.Airplane;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Airplane> airplanes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;



}
