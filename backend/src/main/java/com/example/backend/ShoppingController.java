package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class ShoppingController {

	@Autowired
	private IShoppingcartRepository repo;
	
	@RequestMapping(value = "/create/shoppingcart", method = RequestMethod.POST)
	public void create(@RequestBody Shoppingcart shoppingcart) {
		repo.save(shoppingcart);
	}
	
	@RequestMapping(value = "shoppingcart/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable long id, @RequestBody Shoppingcart shoppingcart) {
		// Database shoppingcart
		Shoppingcart s = repo.findById(id).get();
		
		// Update the db shoppingcart with shoppingcart from the requestbody
		s.setAmount(shoppingcart.getAmount());
		s.setDateCreatedAt(shoppingcart.getDateCreatedAt());
		
		// Save shoppingcart
		repo.save(s);
	}
}
