package com.example.application.UserRepository;

import com.example.application.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository(value="users")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    boolean existsByUsernameAndIdIsNot(String username, Long id);

    boolean existsByEmailAndIdIsNot(String email, Long id);
    @Query("SELECT MAX(u.id) FROM User u")
    long findMaxId();
}