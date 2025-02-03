package com.example.pacientes_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacientes_service.model.PacienteHeartCheck;
import com.example.pacientes_service.repository.PacienteHeartCheckRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ListenerHeartCheck {

    @Autowired
    private PacienteHeartCheckRepository pacienteHeartCheckRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "heartCheck")
    public void recibirHeartCheck(String mensajeJson){
        try{
            System.out.println("Datos entrantes" + mensajeJson);

            PacienteHeartCheck pacienteHeartCheck = objectMapper.readValue(mensajeJson, PacienteHeartCheck.class);
            pacienteHeartCheckRepository.save(pacienteHeartCheck);
            System.out.println("HeartCheck ingresada correctamente: " + mensajeJson);

        }catch (Exception e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        }
    }
}
