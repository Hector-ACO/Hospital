package com.hospital.demo.controller;

import com.hospital.demo.model.Doctor;
import com.hospital.demo.repository.DoctoresRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends GenericController<Doctor> {

    public DoctorController(DoctoresRepository doctoresRepository) {
        super(doctoresRepository);
    }

}
