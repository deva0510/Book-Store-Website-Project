package com.groupproject.boogle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupproject.boogle.model.User;
import com.groupproject.boogle.repository.UserRepository;

@Controller
public class Controllers {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/home")
	public String viewHomePage() {
		return "home";
	}
	
	@GetMapping("/aboutUs")
	public String viewAboutUsPage(Model model) {
		return "aboutUs";
	}
	
	@GetMapping("/books")
	public String viewBooksPage(Model model) {
		return "books";
	}
	
	@GetMapping("/cart")
	public String viewCartPage(Model model) {
		return "cart";
	}
	
	@GetMapping("/product")
	public String viewProductPage(Model model) {
		return "product";
	}
	
	@GetMapping("/account")
	public String viewAccountPage(Model model) {
		return "account";
	}
	
	@GetMapping("/checkout")
	public String viewCheckoutPage(Model model) {
		return "checkout";
	}
	
	@GetMapping("/login")
	public String viewLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		return "login";
	}
}
