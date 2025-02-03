package com.example.pacientes_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "VITAL_SIGNS")
public class PacienteHeartCheck {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVitalSigns;

    @Column(name = "IDPACIENTE", nullable = false)
    private Long idPaciente;

    @Column(name = "HEARTRATE", nullable = false)
    private Double heartRate;

    @Column(name = "FECHA", nullable = false)
    private LocalDateTime fecha;

    // Getters y Setters corregidos
    public Long getIdVitalSigns() {
        return idVitalSigns;
    }

    public void setIdVitalSigns(Long id) {
        this.idVitalSigns = id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) { 
        this.idPaciente = idPaciente;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }
    
    public LocalDateTime getFecha(){
        return fecha;
    }

    public void setFecha(LocalDateTime fecha){
        this.fecha = fecha;
    }
}
