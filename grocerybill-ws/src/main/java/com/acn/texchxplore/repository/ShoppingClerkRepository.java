package com.acn.texchxplore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acn.texchxplore.model.ShoppingClerk;

public interface ShoppingClerkRepository extends JpaRepository<ShoppingClerk, Long>{

    public ShoppingClerk findByName(String name);
	
}
