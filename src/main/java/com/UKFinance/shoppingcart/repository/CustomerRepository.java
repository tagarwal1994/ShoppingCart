package com.UKFinance.shoppingcart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    public Customer getCustomerByEmailAndFirstName(String email,String firstName);

	public Customer findByUserName(String userName);
}
