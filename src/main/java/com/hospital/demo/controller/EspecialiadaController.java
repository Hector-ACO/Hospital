package com.hospital.demo.controller;

import com.hospital.demo.model.Especialidad;
import com.hospital.demo.repository.EspecialidadRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("especialidad")
public class EspecialiadaController extends GenericController<Especialidad> {

    public EspecialiadaController(EspecialidadRepository especialidadRepository) { super(especialidadRepository); }

}
