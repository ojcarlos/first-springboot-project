package com.ojcarlos.simplecrud.repositories;

import com.ojcarlos.simplecrud.entities.OrderItem;
import com.ojcarlos.simplecrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{

}
