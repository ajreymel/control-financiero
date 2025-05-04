package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "nacionalidades")
@Data
public class Nacionalidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nacionalidad")
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
}