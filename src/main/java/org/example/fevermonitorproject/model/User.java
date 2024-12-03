package org.example.fevermonitorproject.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@Entity
@Table(name = "users")


public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    public String username;
    public String password;

    private String firstName;
    private String lastName;
    private String email;
    private Long dateOfBirth;

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
