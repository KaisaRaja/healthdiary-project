package org.example.fevermonitorproject.model;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "fever_record")
public class FeverRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;
    private String temperature;
    private Timestamp closedAt;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
