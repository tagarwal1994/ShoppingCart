package com.UKFinance.shoppingcart.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UKFinance.shoppingcart.entity.Seller;
import com.UKFinance.shoppingcart.exception.NotFoundException;
import com.UKFinance.shoppingcart.repository.SellerRepository;
import com.UKFinance.shoppingcart.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public List<Seller> getAll() {
		return sellerRepository.findAll();
	}

	@Override
	public Seller addSeller(Seller seller) {

		if (seller.getSellerName().length() < 1) {
			return null;
		} else {
			return sellerRepository.save(seller);
		}
	}

	@Override
	public void deleteById(int id) {
		sellerRepository.deleteById(id);
	}

	@Override
	public Seller getSellerById(int id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		return seller.orElseThrow(() -> new NotFoundException("seller couldn't be found by following id: " + id));
	}

	@Override
	public Seller isSellerPresent(String sellerName) {
		return sellerRepository.findBySellerName(sellerName);
	}

}
