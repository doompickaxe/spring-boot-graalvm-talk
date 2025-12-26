package io.kay.spring4.repository;

import io.kay.spring4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
