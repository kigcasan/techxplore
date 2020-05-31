package com.acn.texchxplore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.texchxplore.impl.DiscountedBillServiceImpl;
import com.acn.texchxplore.impl.RegularBillServiceImpl;
import com.acn.texchxplore.model.GroceryBill;
import com.acn.texchxplore.repository.ItemRepository;
import com.acn.texchxplore.repository.ShoppingClerkRepository;
import com.acn.texchxplore.service.GroceryBillService;

@RestController
@RequestMapping(path = "/items/bill")
public class GroceryBillController {

	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private ShoppingClerkRepository shoppingClerkRepo;

	private String shoppingClerkName = "TechXplore";

	
	@GetMapping("discounted")
	public GroceryBill getTotalDiscountedBill() {
		GroceryBillService grocery = new DiscountedBillServiceImpl(shoppingClerkRepo.findByName(shoppingClerkName));
		grocery.setItemList(itemRepo.findAll());

		return grocery.getTotalBill();
	}

	@GetMapping("regular")
	public GroceryBill getTotalRegularBill() {
		GroceryBillService grocery = new RegularBillServiceImpl(shoppingClerkRepo.findByName(shoppingClerkName));
		grocery.setItemList(itemRepo.findAll());

		return grocery.getTotalBill();
	}
}
