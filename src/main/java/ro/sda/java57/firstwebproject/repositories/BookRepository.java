package ro.sda.java57.firstwebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java57.firstwebproject.entities.BookEntities;

public interface BookRepository extends JpaRepository <BookEntities,Long> {
}
