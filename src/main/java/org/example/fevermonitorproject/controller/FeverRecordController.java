package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.model.Patient;
import org.example.fevermonitorproject.repository.FeverRecordRepository;
import org.example.fevermonitorproject.repository.PatientRepository;
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
    @GetMapping("/patients/{patientId}/fever-records")
    public List<FeverRecord> getPatientFeverRecords(@PathVariable Long patientId) {
        return feverRecordRepository.findByPatientId(patientId);
    }
}
// TODO : vaata üle see chati antud koodijupp, ütles, et see võiks sobida ka patsiendikontrollerisse
//@PostMapping("/patients/{patientId}/fever-records")
//public FeverRecord addFeverRecord(@PathVariable Long patientId, @RequestBody FeverRecord feverRecord) {
//    Patient patient = patientRepository.findById(patientId)
//            .orElseThrow(() -> new NoSuchElementException("Patient not found"));
//    feverRecord.setPatient(patient);
//    return feverRecordRepository.save(feverRecord);
//}