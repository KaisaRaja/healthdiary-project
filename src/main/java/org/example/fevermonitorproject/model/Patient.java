package org.example.fevermonitorproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Link to the User table
    private User owner;

    public Patient() {
        this.createdAt = LocalDateTime.now(); // Automatically set the createdAt timestamp
    }

}
