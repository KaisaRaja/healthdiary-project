package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.TreatmentRecord;
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

    @PostMapping("/new")
    public ResponseEntity<TreatmentRecord> addTreatmentRecord(@RequestBody TreatmentRecord record) {
        TreatmentRecord savedRecord = treatmentRecordService.saveTreatmentRecord(record);
        return ResponseEntity.ok(savedRecord);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<TreatmentRecord>> getTreatmentRecords(@PathVariable Long patientId) {
        List<TreatmentRecord> records = treatmentRecordService.getTreatmentRecordsForPatient(patientId);
        return ResponseEntity.ok(records);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TreatmentRecord> updateTreatmentRecord(@PathVariable Long id) {
        TreatmentRecord updatedRecord = treatmentRecordService.updateTreatmentRecord(id);
        return ResponseEntity.ok(updatedRecord);
    }
}
