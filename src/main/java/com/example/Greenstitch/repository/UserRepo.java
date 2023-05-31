package com.example.Greenstitch.repository;

import com.example.Greenstitch.entity.OfficialUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<OfficialUser,Integer> {
    Optional<OfficialUser> findByUserName(String userName);
}
