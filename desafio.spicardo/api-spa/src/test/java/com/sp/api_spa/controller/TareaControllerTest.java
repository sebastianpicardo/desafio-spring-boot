package com.sp.api_spa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.api_spa.dto.TareaDTO;
import com.sp.api_spa.entity.Tarea;
import com.sp.api_spa.service.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)  // Necesario para habilitar Mockito
public class TareaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TareaService tareaService;

    @InjectMocks
    private TareaController tareaController;

    private TareaDTO tareaDTO;

    @BeforeEach
    public void setup() {
        // Configuramos MockMvc para nuestro controlador
        mockMvc = MockMvcBuilders.standaloneSetup(tareaController).build();

        // Creamos un DTO de ejemplo para las pruebas
        tareaDTO = new TareaDTO();
        tareaDTO.setEstadoNombre("Tarea de ejemplo");
        tareaDTO.setDescripcion("Descripción de la tarea");
        // Aquí puedes agregar más propiedades a tareaDTO según tu implementación
    }

    @Test
    public void testCrearTarea() throws Exception {
        // Configuramos el comportamiento del servicio mockeado
        when(tareaService.fromDTO(any(TareaDTO.class))).thenReturn(new Tarea());  // Retorna un objeto Tarea vacío
        when(tareaService.save(any(Tarea.class))).thenReturn(new Tarea());  // Retorna un objeto Tarea vacío
        when(tareaService.toDTO(any(Tarea.class))).thenReturn(tareaDTO);  // Retorna el mismo DTO de tarea

        // Llamamos al endpoint POST para crear la tarea
        mockMvc.perform(post("/api/tareas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tareaDTO)))  // Convierte el DTO a JSON
                .andExpect(status().isCreated())  // Verifica que el status sea 201 Created
                .andExpect(jsonPath("$.nombre").value("Tarea de ejemplo"))  // Verifica que el nombre sea el correcto
                .andExpect(jsonPath("$.descripcion").value("Descripción de la tarea"));  // Verifica que la descripción sea la correcta

        // Verificamos que el servicio 'save' haya sido llamado exactamente una vez
        verify(tareaService, times(1)).save(any(Tarea.class));
    }
}
