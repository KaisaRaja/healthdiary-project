package org.example.fevermonitorproject.service;
import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.repository.FeverRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeverRecordService {
    @Autowired
    private FeverRecordRepository feverRecordRepository;

    public FeverRecord addFeverRecord(FeverRecord record) {
        return feverRecordRepository.save(record);
    }

    public void updateFeverRecord(Long id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        feverRecordRepository.markAsClosed(id, localDateTime);
    }
    public List<FeverRecord> getAllFeverRecords() {
        return feverRecordRepository.findAll();
    }

    public List<FeverRecord> getPatientFeverRecords(Long id) {
        return feverRecordRepository.findByPatientId(id);
    }
}
