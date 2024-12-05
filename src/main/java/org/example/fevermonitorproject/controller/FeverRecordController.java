package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.FeverRecord;
import org.example.fevermonitorproject.service.FeverRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fever")
public class FeverRecordController {
    @Autowired
    private FeverRecordService feverRecordService;


    @PostMapping("/api/fever/new")
    public ResponseEntity<FeverRecord> addRecord(@RequestBody FeverRecord record) {
        return ResponseEntity.ok(feverRecordService.addFeverRecord(record));
    }
//    @DeleteMapping("/api/fever/delete")
//    public ResponseEntity<FeverRecord> deleteRecord(@RequestBody FeverRecord record) {
//    return ResponseEntity.ok(feverRecordService.deleteFeverRecord(record));
//    }
    @PostMapping("/api/fever/update")
    public void updateRecord(@RequestBody FeverRecord record) {
        feverRecordService.updateFeverRecord(record);
    }

    @GetMapping("/api/fever/all")
    public List<FeverRecord> getAllRecords() {
        return feverRecordService.getAllFeverRecords();
    }
}
