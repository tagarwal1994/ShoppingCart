package com.UKFinance.shoppingcart.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.entity.Seller;
import com.UKFinance.shoppingcart.entity.Shipper;
import com.UKFinance.shoppingcart.exception.NotFoundException;
import com.UKFinance.shoppingcart.repository.ShipperRepository;
import com.UKFinance.shoppingcart.service.ShipperService;

@Service
public class ShipperServiceImpl implements ShipperService {

	@Autowired
	private ShipperRepository shipperRepository;

	@Override
	public Shipper isShipperPresent(String shipperName) {
		return shipperRepository.findByShipperName(shipperName);
	}

	@Override
	public Shipper addShipper(Shipper shipper1) {
		if (shipper1.getShipperName().length() < 1) {
			return null;
		} else {
			return shipperRepository.save(shipper1);
		}
	}

	@Override
	public Shipper getShipperById(int shipperId) {
		Optional<Shipper> shipper = shipperRepository.findById(shipperId);
		return shipper
				.orElseThrow(() -> new NotFoundException("seller couldn't be found by following id: " + shipperId));
	}

}
