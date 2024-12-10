package org.example.fevermonitorproject.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Long patientId;

    private String medicationName;
    private String medicationDosage;
    public String getMedicationName() {
        return medicationName;
    }
    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
    public String getMedicationDosage() {
        return medicationDosage;
    }

    public void setMedicationDosage(String medicationDosage) {
        this.medicationDosage = medicationDosage;
    }
}

