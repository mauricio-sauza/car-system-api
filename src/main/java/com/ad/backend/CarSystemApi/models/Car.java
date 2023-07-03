package com.ad.backend.CarSystemApi.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
@Table(name = "cars")
@NoArgsConstructor
//public class Car implements Serializable {
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(unique = true, nullable = false)
    @Column(unique = true, nullable = true)
    private Long id;
//    @NotEmpty
    private String brand;
//    @NotEmpty
    private String model;
//    @NotEmpty
    private String color;
}
