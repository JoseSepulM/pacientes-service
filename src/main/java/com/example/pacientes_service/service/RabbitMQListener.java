// package com.example.pacientes_service.service;

// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.pacientes_service.model.PacienteTemperatura;
// import com.example.pacientes_service.repository.PacienteTemperaturaRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Service
// public class RabbitMQListener {

//     @Autowired
//     private PacienteTemperaturaRepository pacienteTemperaturaRepository;

//     @Autowired
//     private ObjectMapper objectMapper;

//     @RabbitListener(queues = "infoPacientes")
//     public void recibirMensaje(String mensajeJson) {
//         try {
//             Convertir el JSON recibido a un objeto Encuesta
//             PacienteTemperatura pacienteTemperatura = objectMapper.readValue(mensajeJson, PacienteTemperatura.class);
//             pacienteTemperaturaRepository.save(pacienteTemperatura);
//             System.out.println("Temperatura ingresada correctamente: " + mensajeJson);

//         } catch (Exception e) {
//             System.err.println("Error al procesar el mensaje: " + e.getMessage());
//         }
//     }
// }