package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "condicion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condicion {

    @Id
    @Column(name = "id_condicion")
    private Integer idCondicion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cuota")
    private Integer cuota;
}
