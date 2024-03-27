package com.UKFinance.shoppingcart.service;

import java.util.List;

import com.UKFinance.shoppingcart.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	Order getOrderDetail(int orderId);

	List<Order> getOrderListBySellerId(int sellerId);

}
