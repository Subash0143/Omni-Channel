package edu.exaple.Omni_Channel.Repository;

import edu.exaple.Omni_Channel.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}

