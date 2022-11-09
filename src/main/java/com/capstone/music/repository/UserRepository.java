package com.capstone.music.repository;

import com.capstone.music.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
    User findById(Long id);
}
