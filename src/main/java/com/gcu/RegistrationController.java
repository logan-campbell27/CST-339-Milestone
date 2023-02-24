package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.OrderModel;
import com.gcu.model.RegistrationModel;

@Controller
@RequestMapping("/register")
public class RegistrationController{
	
	@Autowired
	SecurityServiceInterface securityService;
	@Autowired
	private OrdersBusinessServiceInterface ordersService;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Registration Form");
		model.addAttribute("registrationModel", new RegistrationModel());
		
		return "registration";
	}
	
	@PostMapping("/doRegistration")
	public String doRegistration(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registration Form");
			return "registration";
		}
		else{
			model.addAttribute("model", registrationModel);
			List<OrderModel> orders = ordersService.getOrders();
			
			model.addAttribute("title","Products:");
			model.addAttribute("orders",orders);
			return "orders";
	
		}
		
		
	}
}