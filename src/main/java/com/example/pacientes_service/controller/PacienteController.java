package com.example.pacientes_service.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// import org.springframework.web.bind.annotation.PathVariable;
// import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;

import com.example.pacientes_service.model.Paciente;
import com.example.pacientes_service.service.PacienteService;

import com.example.pacientes_service.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;






@RestController
@RequestMapping("api/pacientes")
@CrossOrigin
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> ingresarPaciente(@RequestBody Paciente entity) {
        
        Paciente nuevoPaciente = pacienteService.savePaciente(entity);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }
    

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        List<Paciente> pacientes = pacienteService.obtenerListadoPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.obtenerPaciente(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente " + id + " not found"));
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id){

        pacienteService.obtenerPaciente(id)
            .orElseThrow(() -> new ResourceNotFoundException("Paciente " + id + " not found"));

        pacienteService.deletePaciente(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> putMethodName(@PathVariable Long id, @RequestBody Paciente entity) {
       
        Paciente paciente = pacienteService.obtenerPaciente(id)
            .orElseThrow(() -> new ResourceNotFoundException("Paciente " + id + " not found"));

        paciente.setRUT(entity.getRUT());
        paciente.setDV(entity.getDV());
        paciente.setNOMBRE(entity.getNOMBRE());
        paciente.setAPELLIDO(entity.getAPELLIDO());
        paciente.setEDAD(entity.getEDAD());

        Paciente pacienteUpdate = pacienteService.savePaciente(paciente);
        return ResponseEntity.ok(pacienteUpdate);
    }


    

    
}
