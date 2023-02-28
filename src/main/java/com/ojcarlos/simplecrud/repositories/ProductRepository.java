package com.ojcarlos.simplecrud.repositories;

import com.ojcarlos.simplecrud.entities.Category;
import com.ojcarlos.simplecrud.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
