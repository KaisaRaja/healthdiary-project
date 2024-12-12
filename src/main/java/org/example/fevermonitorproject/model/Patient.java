package org.example.fevermonitorproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String patientFullName;

    @Setter
    @Column()
    private LocalDate dateOfBirth;

    @Setter
    private double weight;

    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime closedAt;


    private Long userId;

    public Patient() {
        this.createdAt = LocalDateTime.now();
    }

}
