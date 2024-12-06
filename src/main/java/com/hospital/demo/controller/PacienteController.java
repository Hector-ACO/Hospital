package com.hospital.demo.controller;

import com.hospital.demo.model.Paciente;
import com.hospital.demo.repository.PacienteRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
public class PacienteController extends GenericController<Paciente> {

    public PacienteController(PacienteRepository pacienteRepository) { super(pacienteRepository); }

}
