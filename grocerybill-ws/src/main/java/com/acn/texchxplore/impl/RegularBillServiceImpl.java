package com.acn.texchxplore.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acn.texchxplore.model.GroceryBill;
import com.acn.texchxplore.model.Item;
import com.acn.texchxplore.model.ShoppingClerk;
import com.acn.texchxplore.service.GroceryBillService;

@Service
@Qualifier("regularBillService")
public class RegularBillServiceImpl extends GroceryBillService {

	public RegularBillServiceImpl() {}

	public RegularBillServiceImpl(ShoppingClerk clerk) {
		super(clerk);

	}
	@Override
	public GroceryBill getTotalBill() {
		double priceTotal = itemList.stream().mapToDouble(Item::getPrice).sum();
		return new GroceryBill(clerk, itemList, priceTotal);
	}
}
