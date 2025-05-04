package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "mercaderias")
@Data
public class Mercaderias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @NotNull
    private Marcas marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_impuesto")
    @NotNull
    private TipoImpuesto tipoImpuesto;

    @Column(name = "id_procedencia")
    private Integer idProcedencia;

    @Size(max = 100)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Size(max = 1)
    @NotNull
    @Column(name = "afecta_existencia")
    private String afectaExistencia;

    @NotNull
    @Column(name = "precio_compra", precision = 12)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "precio_venta", precision = 12)
    private BigDecimal precioVenta;
}