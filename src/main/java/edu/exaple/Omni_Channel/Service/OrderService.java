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

    public Order placeOrder(Order order) {
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Channel channel = channelRepository.findById(order.getChannel().getId())
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        order.setCustomer(customer);
        order.setChannel(channel);
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();
        for (OrderItem item : order.getItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            item.setProduct(product);
            item.setPrice(product.getPrice());
            item.setOrder(order);
            items.add(item);
        }
        order.setItems(items);

        return orderRepository.save(order);
    }

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
}
