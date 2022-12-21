package com.pavel.webapp.repositories;

import com.pavel.webapp.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    boolean existsByUsernameOrEmail(String username, String email);

    UserAccount findFirstByUsername(String username);
}
