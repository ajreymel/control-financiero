package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "pedido_compras")
@Data
public class PedidoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    @NotNull
    private Proveedores proveedor;

    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Size(max = 1)
    @NotNull
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    @NotNull
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @NotNull
    private Empleados empleado;

   @ManyToOne
   @JoinColumn(name = "id_condicion")
   @NotNull
   private Condicion condicion;
}