package org.example.fevermonitorproject.service;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.model.TreatmentRecord;
import org.example.fevermonitorproject.repository.TreatmentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TreatmentRecordService {

    @Autowired
    private TreatmentRecordRepository treatmentRecordRepository;

    public TreatmentRecord saveTreatmentRecord(TreatmentRecord record) {
        record.setTimestamp(LocalDateTime.now()); // Määrab automaatselt ajatempli
        return treatmentRecordRepository.save(record);
    }
    // Uuendab raviandmeid ja märgib need sulgemiseks
    public void updateTreatmentRecord(Long id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        treatmentRecordRepository.markAsClosed(id, localDateTime);
    }
    public List<TreatmentRecord> getAllTreatmentRecords() {
        return treatmentRecordRepository.findAll();
    }
    public List<TreatmentRecord> getTreatmentRecordsForPatient(Long patientId) {
        return treatmentRecordRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }
}
