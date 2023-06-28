package com.ad.backend.CarSystemApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor(staticName = "build")
@Table(name = "cars")
@NoArgsConstructor
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
//    @NotEmpty
    private String brand;
//    @NotEmpty
    private String model;
//    @NotEmpty
    private String color;
}
