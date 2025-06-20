package com.transchile.simulador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transchile.simulador.model.Viaje;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class ViajeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void crearYListarViaje() throws Exception {
        Viaje viaje = new Viaje(null, "Santiago", "Valparaíso",
                LocalDate.now(), LocalDate.now().plusDays(2),
                "EN_CURSO", "INTEGRA");

        mockMvc.perform(post("/api/viajes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(viaje)))
            .andExpect(status().isOk());

        mockMvc.perform(get("/api/viajes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)));
    }
}
