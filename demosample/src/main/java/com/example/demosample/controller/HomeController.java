package com.example.demosample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demosample.model.Home;
import com.example.demosample.service.HomeService;



@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService service;
	
	@GetMapping
	public String listHome(Model model) {
		List<Home> home = service.findAll();
		model.addAttribute("home", home);
		return "index";
	}
	
	@GetMapping("/new")
	public String createHome(Model model) {
		model.addAttribute("home", new Home());
		return "home-form";
	}
	
	@PutMapping("/save")
	public String saveHome(@ModelAttribute Home home) {
		service.save(home);
		return "redirect:/home";
	}
	
	@GetMapping("/update/{id}")
	public String getHomeById(@PathVariable int id, Model model) {
		Optional<Home> home = service.getHomeById(id);
		if(home.isPresent()) {
			model.addAttribute("home", home.get());
			return "index";
		}
		else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteHome(@PathVariable ("id") int id) {
		service.deleteById(id);
		return "redirect:/home";
	}
}
