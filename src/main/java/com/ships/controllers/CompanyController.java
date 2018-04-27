package com.ships.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;

@Controller // This means that this class is a Controller
public class CompanyController {
	@Autowired // Bean called CompanyService is auto-generated by Spring, which will use it to handle the data
	private CompanyService CompanyService;

	// Method to display all shipping companies in the 'shipping company' table
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getShippingCompanies(Model s) {
		ArrayList<ShippingCompany> shippingCompaniesList = CompanyService.listAll();

		s.addAttribute("shippingCompaniesList", shippingCompaniesList);

		return "showShippingCompanies";
	}

	// Method to display the addShippingCompany page
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("companyAdd") ShippingCompany c, HttpServletRequest h) {
		return "addShippingCompany";
	}

	// Method to insert the new shipping company into the database
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("companyAdd") ShippingCompany c, BindingResult result,
			HttpServletRequest h, Model s) {

		// If there are errors, prompt the user
		if (result.hasErrors()) {
			return "addShippingCompany";
		}

		// If there are no errors, continue
		else {
			CompanyService.addShipCompany(c);

			ArrayList<ShippingCompany> shippingCompaniesList = CompanyService.listAll();

			s.addAttribute("shippingCompaniesList", shippingCompaniesList);

			// Once the Shipping Company has been added, redirect the user and refresh the page to show them the changes they just made
			return "redirect:showShippingCompanies";
		}
	}

}