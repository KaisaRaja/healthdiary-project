package org.example.fevermonitorproject.service;

import org.example.fevermonitorproject.model.DtoSymptom;
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

    public void saveSymptoms(DtoSymptom symptom) {
        if (symptom.getSpecificSymptomList() != null && symptom.getSpecificSymptomList().isEmpty()) {
            return;
        }
        StringBuilder symptoms = new StringBuilder();

// Loop through the list of specific symptoms
        List<DtoSymptom.SpecificSymptom> specificSymptomList = symptom.getSpecificSymptomList();
        for (DtoSymptom.SpecificSymptom s : specificSymptomList) {
            if (!s.getId().equalsIgnoreCase("7")) {
                // If the StringBuilder is not empty, add a comma before appending the symptom name
                if (symptoms.length() > 0) {
                    symptoms.append(", ");
                }
                symptoms.append(s.getName());
            }
        }

// Add other symptoms if they exist
        if (symptom.getOtherSymptom() != null) {
            if (symptoms.length() > 0) {
                symptoms.append(", ");
            }
            symptoms.append(symptom.getOtherSymptom());
        }

// Convert StringBuilder to a String and assign it to symptoms (or return it as needed)
        String result = symptoms.toString();

        Symptom saveSymptom = new Symptom();
        saveSymptom.setName(String.valueOf(symptoms));
        saveSymptom.setTimestamp(symptom.getTime());
        saveSymptom.setPatientId(symptom.getPatientId());
        symptomRepository.save(saveSymptom);
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
        return symptomRepository.findOpenById(patientId);
    }
}
