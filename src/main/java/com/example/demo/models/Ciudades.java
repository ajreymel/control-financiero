package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ciudades")
@Data
public class Ciudades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    @NotNull
    private Departamentos departamento;

    @NotNull
    @Size(max = 80)
    @Column(unique = true)
    private String descripcion;
}
