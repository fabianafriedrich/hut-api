package com.cct.hut.api.repository;

import com.cct.hut.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Long> {
}
