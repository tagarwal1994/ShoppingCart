package com.UKFinance.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer>{

	Shipper findByShipperName(String shipperName);

}
