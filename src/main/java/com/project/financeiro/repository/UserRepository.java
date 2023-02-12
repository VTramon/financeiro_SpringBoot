package com.project.financeiro.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.financeiro.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
