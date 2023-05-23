package com.maxfromeverett.misto.repository;

import com.maxfromeverett.misto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
