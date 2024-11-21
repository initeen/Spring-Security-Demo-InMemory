package com.mypackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/public/page1")
	public String public1() {
		
		return "public1";
	}
	
	@GetMapping("/public/page2")
	public String public2() {
		
		return "public2";
	}
	
	@GetMapping("/admin/page1")
	public String admin1() {
		
		return "admin1";
	}
	
	@GetMapping("/admin/page2")
	public String admin2() {
		
		return "admin2";
	}
	
	@GetMapping("/emp/page1")
	public String emp1() {
		
		return "emp1";
	}
	
	@GetMapping("/emp/page2")
	public String emp2() {
		
		return "emp2";
	}
	
	@GetMapping("/marketer/page1")
	public String marketer1() {
		
		return "marketer1";
	}
	
	@GetMapping("/marketer/page2")
	public String marketer2() {
		
		return "marketer2";
	}
	
	@GetMapping("/customer/page1")
	public String cuatomer1() {
		
		return "customer1";
	}
	
	@GetMapping("/customer/page2")
	public String customer2() {
		
		return "customer2";
	}
	
	
}
