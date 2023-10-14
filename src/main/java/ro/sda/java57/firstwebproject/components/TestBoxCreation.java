package ro.sda.java57.firstwebproject.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.sda.java57.firstwebproject.entities.BookEntities;
import ro.sda.java57.firstwebproject.repositories.BookRepository;

@Component
public class TestBoxCreation implements CommandLineRunner  {

    @Autowired
    private BookRepository repository;
    @Override
    public void run(String... args) throws Exception {

        BookEntities book1 = BookEntities.builder()
                .titlu("Toamna pe ulita")
                .autor("George Cosbuc")
                .build();

        BookEntities book2 = new BookEntities();
        book2.setAutor("Ion Creanga");
        book2.setTitlu("Amintiri din copilarie");

        BookEntities book3 = new BookEntities("Tudor Arghezi", "Flori de mucegai");

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
    }

}
