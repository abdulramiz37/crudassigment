package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingcartRepository extends JpaRepository<Shoppingcart, Long> {
	
}
