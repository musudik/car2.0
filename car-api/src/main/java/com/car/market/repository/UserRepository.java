package com.car.market.repository;

import com.car.market.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    // Method to check if email already exists
    boolean existsByEmail(String email);
}