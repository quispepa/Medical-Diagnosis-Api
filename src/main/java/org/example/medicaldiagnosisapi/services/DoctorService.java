package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.mappers.DoctorMapper;
import org.example.medicaldiagnosisapi.models.Doctor;
import org.example.medicaldiagnosisapi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

  private final DoctorMapper doctorMapper;
  private final DoctorRepository doctorRepository;

  @Autowired
  public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
    this.doctorMapper = doctorMapper;
    this.doctorRepository = doctorRepository;
  }
  /**
   * Method that returns original entity, only use to services.
   * @param id doctorId to search in repository
   * @return Optional<Doctor> An optional that can content entity object
   */
  public Optional<Doctor> getDoctorEntity(Long id){
    return doctorRepository.findById(id);
  }
}
