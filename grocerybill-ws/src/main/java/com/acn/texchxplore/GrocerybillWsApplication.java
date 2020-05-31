package com.acn.texchxplore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.acn.texchxplore.model.Item;
import com.acn.texchxplore.model.ShoppingClerk;
import com.acn.texchxplore.repository.ItemRepository;
import com.acn.texchxplore.repository.ShoppingClerkRepository;

@SpringBootApplication
public class GrocerybillWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerybillWsApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner loadData(ItemRepository itemRepository, ShoppingClerkRepository shoppingClerkRepository) {
		return (args) -> {
			
			List<Item> itemList = new ArrayList<Item>();
			itemList.add(new Item("Panteen Shampoo", 25.00, false, 0.00));
			itemList.add(new Item("Creamsilk Conditioner", 30.00, false, 0.00));
			itemList.add(new Item("Colgate Toothpaste", 100.00, true, 10.00));
			itemList.add(new Item("Safeguard Soap", 50.00, true, 20.00));
			itemList.add(new Item("Pond's Facial Wash", 75.00, false, 0.00));
			
			itemRepository.saveAll(itemList);
			
			List<ShoppingClerk> shoppingClerks = new ArrayList<>();
			shoppingClerks.add(new ShoppingClerk("TechXplore"));
			shoppingClerks.add(new ShoppingClerk("Accenture"));

			shoppingClerkRepository.saveAll(shoppingClerks);
		};
	}
	

}
