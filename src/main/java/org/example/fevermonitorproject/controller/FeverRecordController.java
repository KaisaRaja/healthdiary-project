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


    @PostMapping
    public ResponseEntity<FeverRecord> addRecord(@RequestBody FeverRecord record) {
        return ResponseEntity.ok(feverRecordService.addFeverRecord(record));
    }

    @GetMapping
    public List<FeverRecord> getAllRecords() {
        return feverRecordService.getAllFeverRecords();
    }
}
