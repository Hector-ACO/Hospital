package com.hospital.demo.controller;

import com.hospital.demo.exception.CustomException;
import com.hospital.demo.model.BaseModel;
import com.hospital.demo.repository.GenericRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class GenericController<T extends BaseModel> {

    private final GenericRepository<T> repository;

    public GenericController(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity get(@RequestParam(required = false) Long id){
        if(id != null){
            return ResponseEntity.ok(repository.findById(id));
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody T entity, Errors errors) throws CustomException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        return ResponseEntity.ok(repository.save(entity));
    }

    @Transactional
    @PutMapping
    public ResponseEntity update(@Valid @RequestBody T entity, Errors errors) throws CustomException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        Optional<T> verify = repository.findById(entity.getId());
        if(verify.isPresent()){
            return ResponseEntity.ok(repository.save(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws CustomException {
        Optional<T> verify = repository.findById(id);
        if (verify.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
