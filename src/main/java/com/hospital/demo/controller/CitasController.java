package com.hospital.demo.controller;

import com.hospital.demo.exception.CustomException;
import com.hospital.demo.model.Citas;
import com.hospital.demo.repository.CitasRepository;
import com.hospital.demo.service.CitasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("citas")
public class CitasController extends GenericController<Citas> {

    public CitasController(CitasRepository citasRepository) {
        super(citasRepository);
    }

    @Autowired
    CitasService citasService;

    @GetMapping("buscar")
    public ResponseEntity findBy(@RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateInicio,
                                 @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFin,
                                 @RequestParam(required = false)Long idConsultorio,
                                 @RequestParam(required = false)Long idDoctor){
        System.out.println(dateFin.getClass());
        return ResponseEntity.ok(citasService.findBy(dateInicio,dateFin,idConsultorio,idDoctor));
    }

    @Override
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Citas entity, Errors errors) throws CustomException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        return ResponseEntity.ok(citasService.save(entity));
    }

    @Override
    @Transactional
    @PutMapping
    public ResponseEntity update(@Valid @RequestBody Citas entity, Errors errors) throws CustomException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        return ResponseEntity.ok(citasService.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws CustomException {
        citasService.cancel(id);
        return ResponseEntity.ok().build();
    }

}
