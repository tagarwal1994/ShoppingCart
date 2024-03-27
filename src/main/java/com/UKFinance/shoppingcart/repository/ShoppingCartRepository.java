package com.UKFinance.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UKFinance.shoppingcart.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	List<ShoppingCart> getAllCartItemsByCustomerId(int id);

	@Modifying
	@Query("update ShoppingCart sc set sc.status = 'Order placed by Customer' where sc.id = ?1")
	void updateCartStatusById(int id);

	//ShoppingCart getcartbyId(int id);

}
