package ro.sda.java57.firstwebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java57.firstwebproject.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findAllByNameAndAgeGreaterThan(String name,int age);
    Optional<UserEntity> findByUsernameIgnoreCase(String username);

}
