package org.example.fevermonitorproject.model;

import java.time.LocalDateTime;
import java.util.List;

public class DtoSymptom {

    private Long patientId;
    private String otherSymptom;
    private List<SpecificSymptom> specificSymptomList;
    private LocalDateTime time;

    // Constructor
    public DtoSymptom(Long patientId, String otherSymptom, List<SpecificSymptom> specificSymptomList, LocalDateTime time) {
        this.patientId = patientId;
        this.otherSymptom = otherSymptom;
        this.specificSymptomList = specificSymptomList;
        this.time = time;
    }

    // Getters and setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getOtherSymptom() {
        return otherSymptom;
    }

    public void setOtherSymptom(String otherSymptom) {
        this.otherSymptom = otherSymptom;
    }

    public List<SpecificSymptom> getSpecificSymptomList() {
        return specificSymptomList;
    }

    public void setSpecificSymptomList(List<SpecificSymptom> specificSymptomList) {
        this.specificSymptomList = specificSymptomList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    // SpecificSymptom class
    public static class SpecificSymptom {
        private String name;
        private String id;

        // Constructor
        public SpecificSymptom(String name, String id) {
            this.name = name;
            this.id = id;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

