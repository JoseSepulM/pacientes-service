package com.example.pacientes_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pacientes_service.model.PatientRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PatientRecordListener {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String ANOMALY_TOPIC = "alertas"; // Nombre del tópico para anomalías

    @KafkaListener(topics = "senales_vitales", groupId = "grupo-consumidor")
    public void consume(String mensaje) {
        try {
            // Convertir el mensaje JSON en un objeto PatientRecord
            ObjectMapper objectMapper = new ObjectMapper();
            PatientRecord record = objectMapper.readValue(mensaje, PatientRecord.class);

            // Detectar anomalías
            if (isAnomaly(record)) {
                // Insertar el registro en el nuevo tópico si es una anomalía
                kafkaTemplate.send(ANOMALY_TOPIC, mensaje); // O puedes mandar el objeto serializado
                System.out.println("Anomalía detectada y enviada al tópico de anomalías.");
            } else {
                System.out.println("Datos normales recibidos.");
            }

        } catch (Exception e) {
            System.err.println("Error procesando el mensaje: " + e.getMessage());
        }
    }

    // Método para detectar anomalías
    private boolean isAnomaly(PatientRecord record) {
        // Lógica para detectar anomalías. Ejemplo:
        boolean isAnomaly = false;

        if (record.getHeartRate() < 60 || record.getHeartRate() > 100) {
            isAnomaly = true;
        }
        if (record.getBodyTemperature() < 36.0 || record.getBodyTemperature() > 37.5) {
            isAnomaly = true;
        }
        if (record.getBloodPressure() < 90 || record.getBloodPressure() > 120) {
            isAnomaly = true;
        }

        return isAnomaly;
    }
}
