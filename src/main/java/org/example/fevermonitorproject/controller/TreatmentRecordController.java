package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.model.TreatmentRecord;
import org.example.fevermonitorproject.repository.TreatmentRecordRepository;
import org.example.fevermonitorproject.service.TreatmentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TreatmentRecordController {

    @Autowired
    private TreatmentRecordService treatmentRecordService;
    @Autowired
    private TreatmentRecordRepository treatmentRecordRepository;

    @PostMapping("/new")
    public ResponseEntity<TreatmentRecord> addTreatmentRecord(@RequestBody TreatmentRecord record) {
        TreatmentRecord savedRecord = treatmentRecordService.saveTreatmentRecord(record);
        return ResponseEntity.ok(savedRecord);
    }
    @PutMapping("/delete/{id}")
    public void updateTreatmentRecord(@PathVariable Long id) {
        treatmentRecordService.updateTreatmentRecord(id);
    }
    @GetMapping("all")
    public List<TreatmentRecord> getAllTreatmentRecords() {
        return treatmentRecordService.getAllTreatmentRecords();
    }
    @GetMapping("/patients/{patientId}/treatment-records")
    public List<TreatmentRecord> getPatientTreatmentRecords(@PathVariable Long patientId) {
        return treatmentRecordRepository.findByPatientIdOrderByTimestampDesc(patientId);
    }
}
