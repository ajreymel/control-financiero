package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "departamentos")
@Data
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_pais")
    @NotNull
    private Paises pais;

    @NotNull
    @Size(max = 80)
    private String descripcion;
}
