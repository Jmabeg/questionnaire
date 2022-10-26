package com.assesment.questionnaire.repository;

import com.assesment.questionnaire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
