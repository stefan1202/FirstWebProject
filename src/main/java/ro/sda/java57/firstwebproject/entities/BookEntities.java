package ro.sda.java57.firstwebproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntities {

    @Id
    @GeneratedValue
    private Long id;

    private String autor;

    private String titlu;

    public BookEntities(String autor, String titlu) {
        this.autor = autor;
        this.titlu = titlu;
    }
}
