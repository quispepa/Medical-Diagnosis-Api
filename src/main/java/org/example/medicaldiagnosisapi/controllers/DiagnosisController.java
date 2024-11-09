package org.example.medicaldiagnosisapi.controllers;

import jakarta.validation.Valid;
import org.example.medicaldiagnosisapi.dtos.requests.UpdateDeseaseAndTreatmentDiagnosis;
import org.example.medicaldiagnosisapi.dtos.responses.DiagnosisResponse;
import org.example.medicaldiagnosisapi.services.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {
  private final DiagnosisService diagnosisService;

  @Autowired
  public DiagnosisController(DiagnosisService diagnosisService) {
    this.diagnosisService = diagnosisService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<DiagnosisResponse> getDiagnosis(@PathVariable Long id){
    Optional<DiagnosisResponse> optionalDiagnosisResponse = diagnosisService.getDiagnosisById(id);
    return optionalDiagnosisResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }
  @GetMapping()
  public ResponseEntity<List<DiagnosisResponse>> getDiagnoses(){
    return ResponseEntity.ok().body(diagnosisService.getAllDiagnoses());
  }

  @PostMapping("/update/{id}")
  public ResponseEntity<DiagnosisResponse> updateDiagnosis(@PathVariable Long id ,@Valid @RequestBody UpdateDeseaseAndTreatmentDiagnosis updateDeseaseAndTreatmentDiagnosis){
    Optional<DiagnosisResponse> optionalDiagnosisResponse = diagnosisService.updateDeseaseAndTreatmentDiagnosis(id, updateDeseaseAndTreatmentDiagnosis);
    return optionalDiagnosisResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }


}
