package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipsInterface;

@Service // Define the following class as a service (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html)
public class ShipsService
{
	@Autowired // Bean called shipsInterface is auto-generated by Spring, which will use it to handle the data
	private ShipsInterface shipsInterface;
	
	public ArrayList<Ship> listAll()
	{
		// Find all elements in the 'Ship' table and put them in an ArrayList called 'ships'
		return (ArrayList<Ship>) shipsInterface.findAll();
	}
	
	public Ship addShip(Ship ship) 
	{
		return shipsInterface.save(ship);
	}
}