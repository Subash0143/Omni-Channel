package edu.exaple.Omni_Channel.Repository;


import edu.exaple.Omni_Channel.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
