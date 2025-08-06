package com.marcon.course.repositories;

import com.marcon.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdereItemRepository extends JpaRepository<Order.OrderItem, Long> {

}
