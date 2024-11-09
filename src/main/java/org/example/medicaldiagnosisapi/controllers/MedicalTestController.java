package org.example.medicaldiagnosisapi.controllers;

import org.example.medicaldiagnosisapi.dtos.requests.UpdateResultMedicalTestRequest;
import org.example.medicaldiagnosisapi.dtos.responses.MedicalTestResponse;
import org.example.medicaldiagnosisapi.services.MedicalTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/medicalTest")
public class MedicalTestController {
  private final MedicalTestService medicalTestService;

  public MedicalTestController(MedicalTestService medicalTestService) {
    this.medicalTestService = medicalTestService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<MedicalTestResponse> getResultMedical(@PathVariable Long id){
    Optional<MedicalTestResponse> optionalMedicalTestResponse = medicalTestService.getResultMedicalTest(id);
    return optionalMedicalTestResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

  @PatchMapping("/addResult/{id}")
  public ResponseEntity<MedicalTestResponse> updateResultMedicalTest(@PathVariable Long id, @RequestBody UpdateResultMedicalTestRequest updateResultMedicalTestRequest){
    Optional<MedicalTestResponse> optionalMedicalTestResponse = medicalTestService.updateResultMedicalTest(id, updateResultMedicalTestRequest);
    return optionalMedicalTestResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }
}
