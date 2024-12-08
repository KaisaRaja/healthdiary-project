package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.model.Patient;
import org.example.fevermonitorproject.repository.FeverRecordRepository;
import org.example.fevermonitorproject.repository.PatientRepository;
import org.example.fevermonitorproject.service.FeverRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/fever")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeverRecordController {
    @Autowired
    private FeverRecordService feverRecordService;
    @Autowired
    private FeverRecordRepository feverRecordRepository;


    @PostMapping("new")
    public ResponseEntity<FeverRecord> addFeverRecord(@RequestBody FeverRecord record) {
        return ResponseEntity.ok(feverRecordService.addFeverRecord(record));
    }

    @PutMapping("delete/{id}")
    public void updateFeverRecord(@PathVariable Long id) {
        feverRecordService.updateFeverRecord(id);
    }

    @GetMapping("all")
    public List<FeverRecord> getAllFeverRecords() {
        return feverRecordService.getAllFeverRecords();
    }
    @GetMapping("/patients/{patientId}/fever-records")
    public List<FeverRecord> getPatientFeverRecords(@PathVariable Long patientId) {
        return feverRecordRepository.findOpenRecordsByPatientId(patientId);
    }
}