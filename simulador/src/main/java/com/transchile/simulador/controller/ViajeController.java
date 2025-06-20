package com.transchile.simulador.controller;

import com.transchile.simulador.model.Viaje;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    private final List<Viaje> viajes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Viaje crearViaje(@RequestBody Viaje viaje) {
        viaje.setId(counter.incrementAndGet());
        viajes.add(viaje);
        return viaje;
    }

    @GetMapping
    public List<Viaje> listarViajes() {
        return viajes;
    }

    @GetMapping("/buscar")
    public List<Viaje> filtrar(
            @RequestParam Optional<String> estadoViaje,
            @RequestParam Optional<String> estadoMercancia) {
        return viajes.stream()
            .filter(v -> estadoViaje.map(ev -> v.getEstadoViaje().equalsIgnoreCase(ev)).orElse(true))
            .filter(v -> estadoMercancia.map(em -> v.getEstadoMercancia().equalsIgnoreCase(em)).orElse(true))
            .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        viajes.removeIf(v -> v.getId().equals(id));
    }
}
