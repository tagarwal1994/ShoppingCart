package com.UKFinance.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.BillingAddress;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer> {

	List<BillingAddress> getAddressByCustomerId(int customer_Id);

}
