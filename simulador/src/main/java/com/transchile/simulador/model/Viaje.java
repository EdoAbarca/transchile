package com.transchile.simulador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaje {
    private Long id;
    private String origen;
    private String destino;
    private LocalDate fechaInicio;
    private LocalDate fechaLlegada;
    private String estadoViaje;       // Ej: "EN_CURSO", "FINALIZADO", "CANCELADO"
    private String estadoMercancia;   // Ej: "INTEGRA", "DAÑADA", "DESCONOCIDO"
}
