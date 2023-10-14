package ro.sda.java57.firstwebproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private String email;
    private int age;
}
