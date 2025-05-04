
package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Column(name = "legajo")
    private String legajo;

    @ManyToOne
    @JoinColumn(name = "id_barrio")
    @NotNull
    private Barrios barrio;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad")
    @NotNull
    private Nacionalidades nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @NotNull
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil")
    @NotNull
    private EstadoCivil estadoCivil;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombres")
    private String nombres;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidos")
    private String apellidos;

    @Size(max = 20)
    @NotNull
    @Column(name = "cedula_identidad")
    private String cedulaIdentidad;

    @NotNull
    @Column(name = "fecha_nac")
    private LocalDate fechaNac;

    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;

    @Size(max = 1)
    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_incorporacion")
    private LocalDate fechaIncorporacion;

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
}