package org.example.fevermonitorproject.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "fever_record")
public class FeverRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;

    private String temperature; // komakoha tõttu

    private LocalDateTime time;
    @Setter
    private LocalDateTime createdAt;
    @Getter
    private LocalDateTime closedAt;
    public void setClosedAt(LocalDateTime now) {
    }

    @ManyToOne
    @JoinColumn(name= "patient-id")
    private Patient patient;

}

