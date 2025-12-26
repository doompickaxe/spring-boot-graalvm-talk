package io.kay.normal.repository;

import io.kay.normal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
