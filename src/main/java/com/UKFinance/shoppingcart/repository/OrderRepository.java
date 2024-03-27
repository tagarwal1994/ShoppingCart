package com.UKFinance.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

	List<Order> getOrderListBySellerId(int sellerId);
}
