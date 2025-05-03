package edu.exaple.Omni_Channel.Service;

import edu.exaple.Omni_Channel.Entities.Order;
import edu.exaple.Omni_Channel.Entities.OrderItem;
import edu.exaple.Omni_Channel.Entities.Product;
import edu.exaple.Omni_Channel.Repository.OrderRepository;
import edu.exaple.Omni_Channel.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ProductRepository productRepository;

    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        for (OrderItem item : order.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < item.getQuantity())
                throw new RuntimeException("Insufficient stock for: " + product.getName());

            product.setStock(product.getStock() - item.getQuantity());
            item.setProduct(product);
            item.setOrder(order);
            item.setPrice(product.getPrice());
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
