package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value = "select * from public.\"user\" where \"username\" = ?1",
    nativeQuery = true)
    User getUserByUserName(String username);
}
