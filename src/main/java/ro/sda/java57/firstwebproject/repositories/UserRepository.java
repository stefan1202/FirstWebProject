package ro.sda.java57.firstwebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ro.sda.java57.firstwebproject.entities.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findAllByNameAndAgeGreaterThan(String name,int age);
}
