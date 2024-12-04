package org.example.fevermonitorproject.service;
import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.repository.FeverRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeverRecordService {
    @Autowired
    private FeverRecordRepository feverRecordRepository;

    public FeverRecord addFeverRecord(FeverRecord record) {
        return feverRecordRepository.save(record);
    }

    public List<FeverRecord> getAllFeverRecords() {
        return feverRecordRepository.findAll();
    }
}
