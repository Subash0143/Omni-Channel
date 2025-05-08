package edu.exaple.Omni_Channel.dto;

import java.math.BigDecimal;

public class UnifiedDashboardDTO {

    private long totalOrders;
    private long totalCustomers;
    private long totalProducts;
    private long totalChannels;
    private BigDecimal totalRevenue;

    public UnifiedDashboardDTO() {
    }

    public UnifiedDashboardDTO(long totalOrders, long totalCustomers, long totalProducts, long totalChannels, BigDecimal totalRevenue) {
        this.totalOrders = totalOrders;
        this.totalCustomers = totalCustomers;
        this.totalProducts = totalProducts;
        this.totalChannels = totalChannels;
        this.totalRevenue = totalRevenue;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalChannels() {
        return totalChannels;
    }

    public void setTotalChannels(long totalChannels) {
        this.totalChannels = totalChannels;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
