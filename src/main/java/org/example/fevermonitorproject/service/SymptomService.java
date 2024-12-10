package org.example.fevermonitorproject.service;

import org.example.fevermonitorproject.model.Symptom;
import org.example.fevermonitorproject.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SymptomService {

    @Autowired
    private final SymptomRepository symptomRepository;

    public SymptomService(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }
    public List<Symptom> saveSymptoms(List<String> symptomNames) {
        List<Symptom> symptoms = symptomNames.stream()
                .map(name -> {
                    Symptom symptom = new Symptom();
                    symptom.setName(name);
                    symptom.setTimestamp(LocalDateTime.now()); // Määrame ajatempli
                    return symptom;
                })
                .toList();
        return symptomRepository.saveAll(symptoms);
    }
    // Uuendab raviandmeid ja märgib need sulgemiseks
    public void updateSymptom(Long id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        symptomRepository.markAsClosed(id, localDateTime);
    }
    public List<Symptom> getAllSymptoms() {
        return symptomRepository.findAll();
    }
    public List<Symptom> getSymptomsForPatient(Long patientId) {
        return symptomRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }
}
