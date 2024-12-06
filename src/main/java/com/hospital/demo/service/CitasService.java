package com.hospital.demo.service;

import com.hospital.demo.exception.CustomException;
import com.hospital.demo.model.Citas;
import com.hospital.demo.repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitasService {

    @Autowired
    CitasRepository citasRepository;

    public List<Citas> findBy(LocalDateTime dateInicio, LocalDateTime datefin, Long idConsultorio, Long idDoctor) {
        return citasRepository.findByCriteria(dateInicio,datefin,idConsultorio,idDoctor);
    }

    public Citas save(Citas cita) throws CustomException {
        if(!citasRepository.findByTimeBetweenAndConsultorio
                        (cita.getHoraInicio(),cita.getHoraFin(),cita.getConsultorio().getId(),null).isEmpty()){
            throw new CustomException(406,"El consultorio se encuentra ocupado");
        }
        if(!citasRepository.findByTimeBetweenAndDoctor
                (cita.getHoraInicio(),cita.getHoraFin(),cita.getDoctor().getId(),null).isEmpty()){
            throw new CustomException(406,"El Doctor se encuentra ocupado");
        }

        LocalDateTime startOfDay = cita.getHoraFin().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = cita.getHoraFin().plusDays(1).toLocalDate().atStartOfDay();

        if(citasRepository.findByDoctorAndHoraFinBetween(startOfDay,endOfDay,cita.getDoctor().getId(), null).size() <= 8) {
            throw new CustomException(406,"El Doctor ya cuenta con 8");
        }
        if(!citasRepository.findByTimeBetweenAndPaciente
                (cita.getHoraInicio().minusHours(2),cita.getHoraFin().plusHours(2),cita.getPaciente().getId(),null).isEmpty()){
            throw new CustomException(406,"El Paciente ya cuenta con una cita");
        }
        return citasRepository.save(cita);
    }

    public Citas update(Citas cita) throws CustomException {
        if(citasRepository.findById(cita.getId()).isEmpty()){
            throw new CustomException(404, "La cita con el id " + cita.getId() + " no existe");
        }
        if(!citasRepository.findByTimeBetweenAndConsultorio
                (cita.getHoraInicio(),cita.getHoraFin(),cita.getConsultorio().getId(),cita.getId()).isEmpty()){
            throw new CustomException(406,"El consultorio se encuentra ocupado");
        }
        if(!citasRepository.findByTimeBetweenAndDoctor
                (cita.getHoraInicio(),cita.getHoraFin(),cita.getDoctor().getId(),cita.getId()).isEmpty()){
            throw new CustomException(406,"El Doctor se encuentra ocupado");
        }

        LocalDateTime startOfDay = cita.getHoraFin().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = cita.getHoraFin().plusDays(1).toLocalDate().atStartOfDay();

        if(citasRepository.findByDoctorAndHoraFinBetween(startOfDay,endOfDay,cita.getDoctor().getId(), cita.getId()).size() <= 8) {
            throw new CustomException(406,"El Doctor ya cuenta con 8");
        }
        if(!citasRepository.findByTimeBetweenAndPaciente
                (cita.getHoraInicio().minusHours(2),cita.getHoraFin().plusHours(2),cita.getPaciente().getId(),cita.getId()).isEmpty()){
            throw new CustomException(406,"El Paciente ya cuenta con una cita");
        }
        return citasRepository.save(cita);
    }

    public void cancel(Long id) throws CustomException {
        Citas cita = citasRepository.findById(id).orElseThrow(() -> new CustomException(404, "La cita con el id " + id + " no existe"));
        if(cita.getHoraInicio().isAfter(LocalDateTime.now())) {
            throw new CustomException(406,"La hora de la cita ya ha expirado");
        }
        citasRepository.deleteById(id);
    }

}
