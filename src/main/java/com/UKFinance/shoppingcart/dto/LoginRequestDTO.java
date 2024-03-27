package com.UKFinance.shoppingcart.dto;

import java.util.List;

import com.UKFinance.shoppingcart.entity.ShoppingCart;

public class LoginRequestDTO {

	private String userName;
	private String password;
	private List<ShoppingCartDTO> shoppingCartDTO;

	public LoginRequestDTO(String userName, String password, List<ShoppingCartDTO> shoppingCartDTO) {
		super();
		this.userName = userName;
		this.password = password;
		this.shoppingCartDTO = shoppingCartDTO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ShoppingCartDTO> getShoppingCartDTO() {
		return shoppingCartDTO;
	}

	public void setShoppingCartDTO(List<ShoppingCartDTO> shoppingCartDTO) {
		this.shoppingCartDTO = shoppingCartDTO;
	}

	@Override
	public String toString() {
		return "LoginRequestDTO [userName=" + userName + ", password=" + password + ", shoppingCartDTO="
				+ shoppingCartDTO + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
				+ ", getShoppingCartDTO()=" + getShoppingCartDTO() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
