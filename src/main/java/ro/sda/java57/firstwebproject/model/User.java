package ro.sda.java57.firstwebproject.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    @NotNull
    private String name;
    @NotBlank
    @Email
    private String email;
    @Min(18)
    private int age;
}
