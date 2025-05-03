package edu.exaple.Omni_Channel.Repository;


import edu.exaple.Omni_Channel.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
