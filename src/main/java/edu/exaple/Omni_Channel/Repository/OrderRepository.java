package edu.exaple.Omni_Channel.Repository;


import edu.exaple.Omni_Channel.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT SUM(oi.price * oi.quantity) FROM OrderItem oi")
    BigDecimal calculateTotalRevenue();

}
