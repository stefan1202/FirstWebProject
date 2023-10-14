package ro.sda.java57.firstwebproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private int age;
}
