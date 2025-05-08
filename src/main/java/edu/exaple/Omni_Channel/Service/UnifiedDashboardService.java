package edu.exaple.Omni_Channel.Service;

import edu.exaple.Omni_Channel.dto.UnifiedDashboardDTO;
import edu.exaple.Omni_Channel.Repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UnifiedDashboardService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ChannelRepository channelRepository;

    public UnifiedDashboardService(OrderRepository orderRepository,
                                   ProductRepository productRepository,
                                   CustomerRepository customerRepository,
                                   ChannelRepository channelRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.channelRepository = channelRepository;
    }

    public UnifiedDashboardDTO getDashboardData() {
        long totalOrders = orderRepository.count();
        long totalCustomers = customerRepository.count();
        long totalProducts = productRepository.count();
        long totalChannels = channelRepository.count();
        BigDecimal totalRevenue = orderRepository.calculateTotalRevenue();

        return new UnifiedDashboardDTO(totalOrders, totalCustomers, totalProducts, totalChannels, totalRevenue);
    }
}
