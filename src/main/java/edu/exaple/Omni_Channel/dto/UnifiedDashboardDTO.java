package edu.exaple.Omni_Channel.dto;

import java.math.BigDecimal;

public class UnifiedDashboardDTO {

    private long productCount;
    private long orderCount;
    private long customerCount;
    private long channelCount;
    private double totalRevenue;

    // Default constructor
    public UnifiedDashboardDTO(long totalOrders, long totalCustomers, long totalProducts, long totalChannels, BigDecimal totalRevenue) {
    }

    // All-args constructor (optional)
    public UnifiedDashboardDTO(long productCount, long orderCount, long customerCount, long channelCount, double totalRevenue) {
        this.productCount = productCount;
        this.orderCount = orderCount;
        this.customerCount = customerCount;
        this.channelCount = channelCount;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }

    public long getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(long customerCount) {
        this.customerCount = customerCount;
    }

    public long getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(long channelCount) {
        this.channelCount = channelCount;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
