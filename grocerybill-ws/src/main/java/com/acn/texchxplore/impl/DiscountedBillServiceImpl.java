package com.acn.texchxplore.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acn.texchxplore.model.GroceryBill;
import com.acn.texchxplore.model.Item;
import com.acn.texchxplore.model.ShoppingClerk;
import com.acn.texchxplore.service.GroceryBillService;

@Service
@Qualifier("discountedBillService")
public class DiscountedBillServiceImpl extends GroceryBillService {
	
	public DiscountedBillServiceImpl() {}

	public DiscountedBillServiceImpl(ShoppingClerk clerk) {
		super(clerk);
	}

	@Override
	public GroceryBill getTotalBill() {
		double priceTotal = 0;
		for (Item item : itemList) {
			priceTotal += item.getPrice();
			if (item.isDiscounted())
				priceTotal -= (item.getPrice() * (item.getDiscountPercentage() / 100));
		} 
		return new GroceryBill(clerk, itemList, priceTotal);
	}

}
