package com.ojcarlos.simplecrud.repositories;

import com.ojcarlos.simplecrud.entities.Category;
import com.ojcarlos.simplecrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long>{

}
