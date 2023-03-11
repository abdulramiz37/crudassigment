package com.example.backend;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class StatusController {
	
	@Autowired
	private IShoppingcartRepository repo;
	
	@RequestMapping(value = "shoppingcarts")
	public List<Shoppingcart> findAllShoppingCarts() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "shoppingcart")
	public Shoppingcart shoppingcart() {
		Shoppingcart s = new Shoppingcart();
		s.setId(1);
		s.setName("Apples");
		s.setDescription("Fruits");
		s.setAmount(50);
		s.setDateCreatedAt(LocalDate.now());
		return s;
	}
	
	@RequestMapping(value = "status")
	public String status() {
		return "OK";
	}
	
	@RequestMapping(value = "person")
	public Person person() {
		Person p = new Person();
		p.setFirstName("Aman");
		p.setLastName("Ahmed");
		return p;
	}
}
