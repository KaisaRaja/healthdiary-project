package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.repository.FeverRecordRepository;
import org.example.fevermonitorproject.service.FeverRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<FeverRecord> deleteFeverRecord(@PathVariable Long id) {
//    return ResponseEntity.ok(feverRecordService.deleteFeverRecord(id));
//    }
    @PutMapping("update/{id}")
    public void updateFeverRecord(@RequestBody FeverRecord record, Long id) {
        feverRecordService.updateFeverRecord(record);
    }

    @GetMapping("all")
    public List<FeverRecord> getAllFeverRecords() {
        return feverRecordService.getAllFeverRecords();
    }
    @GetMapping("/all-records/by-patient-id/{id}")
    public ResponseEntity<List<FeverRecord>> getPatientFeverRecords(@PathVariable Long feverRecordId) {
        return ResponseEntity.ok(feverRecordService.getFeverRecordsByPatient(feverRecordId));
}
}

