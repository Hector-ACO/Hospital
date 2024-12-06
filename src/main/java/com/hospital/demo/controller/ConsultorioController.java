package com.hospital.demo.controller;

import com.hospital.demo.model.Consultorio;
import com.hospital.demo.repository.ConsultorioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultorio")
public class ConsultorioController extends GenericController<Consultorio> {

    public ConsultorioController(ConsultorioRepository consultorioRepository) { super(consultorioRepository); }

}
