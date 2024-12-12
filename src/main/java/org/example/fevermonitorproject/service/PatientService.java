package org.example.fevermonitorproject.service;

import org.example.fevermonitorproject.model.Patient;
import org.example.fevermonitorproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public Patient addPatient(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll().stream()
                .filter(patient -> patient.getClosedAt() == null)
                .toList();
    }

    public Optional<Patient> getPatientById(Long id) {
        return repository.findById(id);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        return repository.findById(id).map(patient -> {
            patient.setPatientFullName(updatedPatient.getPatientFullName());
            if (updatedPatient.getDateOfBirth() != null) {
                patient.setDateOfBirth(updatedPatient.getDateOfBirth());
            }
            patient.setWeight(updatedPatient.getWeight());
            return repository.save(patient);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    public void removePatient(Long id) {
        repository.findById(id).ifPresent(patient -> {
            patient.setClosedAt(LocalDateTime.now());
            repository.save(patient);
        });
    }

    public List<Patient> getPatientsByUser(Long userId) {
        return repository.findAllOpenByUserId(userId);
    }

}
