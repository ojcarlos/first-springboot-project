package com.ojcarlos.simplecrud.repositories;

import com.ojcarlos.simplecrud.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{

}
