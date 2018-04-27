package com.ships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInterface;
import com.ships.repositories.ShipsInterface;
import com.ships.repositories.CompanyInterface;

@Service // Define the following class as a service (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html)
public class OrderService 
{
	
	@Autowired // Bean called orderInterface is auto-generated by Spring, which will use it to handle the data
	private OrderInterface orderInterface;

	@Autowired // Bean called shipsInterface is auto-generated by Spring, which will use it to handle the data
	private ShipsInterface shipsInterface;
	
	@Autowired // Bean called CompanyInterface is auto-generated by Spring, which will use it to handle the data
	private CompanyInterface CompanyInterface;

	@Autowired
	private ShipsService shipsService;
	
	private Ship ship;
	private ShippingCompany ShippingCompany;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	
	public ArrayList<OrderInfo> listAll()
	{
		
		return (ArrayList<OrderInfo>) orderInterface.findAll();
	}
	
	public OrderInfo save(OrderInfo order)
	{
		
		if (shipsInterface.findOne( order.getShip().getSid()) != null)
		{
			ship = shipsInterface.findOne( order.getShip().getSid());
		}
		
		ShippingCompany = CompanyInterface.findOne( order.getShippingCompany().getScid());
		
		ship.setShippingCompany(order.getShippingCompany());
		
		shipsService.addShip(ship);
		
		order.setShippingCompany(ShippingCompany);
		order.setDate(dateFormat.format(date));
		
		return orderInterface.save(order);
	}
	
}