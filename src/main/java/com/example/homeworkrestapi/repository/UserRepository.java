package com.example.homeworkrestapi.repository;

import com.example.homeworkrestapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
