package org.example.fevermonitorproject.repository;

import org.example.fevermonitorproject.model.FeverRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface FeverRecordRepository extends JpaRepository<FeverRecord, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE FeverRecord f SET f.closedAt = :closedAt WHERE f.id = :id")
    void markAsClosed(@Param("id") Long id, @Param("closedAt") LocalDateTime closedAt);

    @Query("SELECT f FROM FeverRecord f WHERE f.patientId = :patientId AND f.closedAt IS NULL")
    List<FeverRecord> findOpenRecordsByPatientId(@Param("patientId") Long patientId);

    List<FeverRecord> findByPatientId(Long patientId);

}