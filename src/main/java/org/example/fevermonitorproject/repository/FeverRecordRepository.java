package org.example.fevermonitorproject.repository;

import org.example.fevermonitorproject.model.FeverRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeverRecordRepository extends JpaRepository<FeverRecord, Long> {

}