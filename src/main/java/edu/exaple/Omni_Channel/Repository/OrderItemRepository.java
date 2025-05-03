package edu.exaple.Omni_Channel.Repository;

import edu.exaple.Omni_Channel.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
