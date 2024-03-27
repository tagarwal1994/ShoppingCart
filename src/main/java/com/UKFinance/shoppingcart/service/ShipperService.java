package com.UKFinance.shoppingcart.service;

import com.UKFinance.shoppingcart.entity.Shipper;

public interface ShipperService {

	Shipper isShipperPresent(String shipperName);

	Shipper addShipper(Shipper shipper1);

	Shipper getShipperById(int shipperId);

}
