package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_barrio")
    @NotNull
    private Barrios barrio;

    @Size(max = 100)
    @NotNull
    @Column(name = "razon_social")
    private String razonSocial;

    @Size(max = 20)
    @NotNull
    @Column(name = "ruc")
    private String ruc;

    @Size(max = 100)
    @NotNull
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 20)
    @NotNull
    @Column(name = "telefono")
    private String telefono;

    @Size(max = 50)
    @NotNull
    @Column(name = "email")
    private String email;

    @Size(max = 3)
    @Column(name = "tipo_persona")
    private String tipoPersona;
}