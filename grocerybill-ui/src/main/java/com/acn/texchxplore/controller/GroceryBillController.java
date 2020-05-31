package com.acn.texchxplore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.acn.texchxplore.configuration.ServerAppConfiguration;
import com.acn.texchxplore.model.GroceryBill;

@Controller 
@RefreshScope
@RibbonClient(name = "${ribbonclient.name}", configuration = ServerAppConfiguration.class)
@RequestMapping(path="/techxplore")
public class GroceryBillController {
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${header.title:headerTitle}")
	private String headerTitle;
	
	@Value("${grocerybill.regular.url}")
	private String regularURL;

	@Value("${grocerybill.discounted.url}")
	private String discountedURL;
	
	
	@GetMapping("grocery")
	public String getIndexPage(Model model) { 
						
		model.addAttribute("headerTitle", headerTitle);
		
		GroceryBill regular = this.restTemplate.getForObject(regularURL, GroceryBill.class);
		model.addAttribute("clerk", regular.getClerk());
		model.addAttribute("regularBill", regular);		
		
		GroceryBill discounted = this.restTemplate.getForObject(discountedURL, GroceryBill.class);		
		model.addAttribute("discountedBill", discounted);		
		
		return "grocery";
	}

}
