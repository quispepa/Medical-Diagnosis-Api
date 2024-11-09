package org.example.medicaldiagnosisapi.controllers;

import org.example.medicaldiagnosisapi.dtos.responses.MedicalRecordResponse;
import org.example.medicaldiagnosisapi.services.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/medicalRecord")
public class MedicalRecordController {
  private final MedicalRecordService medicalRecordService;

  public MedicalRecordController(MedicalRecordService medicalRecordService) {
    this.medicalRecordService = medicalRecordService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicalRecordResponse> getMedicalRecordById(@PathVariable Long id){
    Optional<MedicalRecordResponse> optionalMedicalRecordResponse = medicalRecordService.getMedicalRecord(id);
    return optionalMedicalRecordResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

}
