package org.example.fevermonitorproject.service;

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

    public List<TreatmentRecord> getTreatmentRecordsForPatient(Long patientId) {
        return treatmentRecordRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }
    // Uuendab raviandmeid ja märgib need sulgemiseks
    public TreatmentRecord updateTreatmentRecord(Long id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        treatmentRecordRepository.markAsClosed(id, localDateTime);

        // Siin võiks olla kood, mis uuendab muid andmeid, kui vaja
        return treatmentRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TreatmentRecord not found with id " + id));
    }
}
