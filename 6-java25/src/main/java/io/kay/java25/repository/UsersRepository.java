package io.kay.java25.repository;

import io.kay.java25.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
