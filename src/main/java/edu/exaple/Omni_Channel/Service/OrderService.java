package edu.exaple.Omni_Channel.Service;
import edu.exaple.Omni_Channel.Entities.*;
import edu.exaple.Omni_Channel.Repository.ChannelRepository;
import edu.exaple.Omni_Channel.Repository.CustomerRepository;
import edu.exaple.Omni_Channel.Repository.OrderRepository;
import edu.exaple.Omni_Channel.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order update(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(updatedOrder.getStatus());
        // Additional updates can be handled here

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
    public Order placeOrder(Order order) {
        for (OrderItem item : order.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + item.getProduct().getId()));

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            // Deduct stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            item.setProduct(product); // Ensure correct reference
            item.setPrice(product.getPrice());
            item.setOrder(order);
        }

        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

}
