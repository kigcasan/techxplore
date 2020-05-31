package com.acn.texchxplore.service;

import java.util.ArrayList;
import java.util.List;

import com.acn.texchxplore.model.GroceryBill;
import com.acn.texchxplore.model.Item;
import com.acn.texchxplore.model.ShoppingClerk;

public abstract class GroceryBillService {
	
	protected List<Item> itemList = new ArrayList<Item>();
	protected ShoppingClerk clerk;

	public GroceryBillService() {}

	public GroceryBillService(ShoppingClerk clerk) {
		this.clerk = clerk;
	}
	
	public ShoppingClerk getClerk() {
		return clerk;
	}

	public void setClerk(ShoppingClerk clerk) {
		this.clerk = clerk;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public abstract GroceryBill getTotalBill();

}
