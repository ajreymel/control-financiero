package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "marcas")
@Data
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
}