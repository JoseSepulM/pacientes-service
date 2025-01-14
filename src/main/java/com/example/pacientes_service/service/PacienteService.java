package com.example.pacientes_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacientes_service.model.Paciente;
import com.example.pacientes_service.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerListadoPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtenerPaciente(Long id){
        return pacienteRepository.findById(id);
    }

    public Paciente savePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }
    
}
