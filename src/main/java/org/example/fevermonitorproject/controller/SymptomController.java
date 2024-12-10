package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.Symptom;
import org.example.fevermonitorproject.repository.SymptomRepository;
import org.example.fevermonitorproject.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SymptomController {

    @Autowired
    private final SymptomService symptomService;
    @Autowired
    private SymptomRepository symptomRepository;

    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @PostMapping("/new")
    public List<Symptom> saveSymptoms(@RequestBody List<String> symptomNames) {
        return symptomService.saveSymptoms(symptomNames);
    }
    @PutMapping("/delete/{id}")
    public void updateSymptom(@PathVariable Long id) {
        symptomService.updateSymptom(id);
    }
    @GetMapping("all")
    public List<Symptom> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }
    @GetMapping("/patients/{patientId}/symptom-records")
    public List<Symptom> getPatientSymptoms(@PathVariable Long patientId) {
        return symptomRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }
}
