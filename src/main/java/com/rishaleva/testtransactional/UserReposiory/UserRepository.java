package com.rishaleva.testtransactional.UserReposiory;

import com.rishaleva.testtransactional.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
