package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "tipo_impuesto")
@Data
public class TipoImpuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_impuesto")
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private Integer tipo;
}