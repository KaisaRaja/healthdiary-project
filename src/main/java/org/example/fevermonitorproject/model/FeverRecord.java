package org.example.fevermonitorproject.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class FeverRecord {
    @jakarta.persistence.Id
    @Id // TODO vaata , kas on õige import
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private double temperature;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
