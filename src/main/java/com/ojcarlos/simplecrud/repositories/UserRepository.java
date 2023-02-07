package com.ojcarlos.simplecrud.repositories;

import com.ojcarlos.simplecrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

}
