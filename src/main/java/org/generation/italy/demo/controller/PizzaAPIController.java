package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;

import org.generation.italy.demo.service.IngredientService;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/pizza")
@CrossOrigin("*")
public class PizzaAPIController {
	
	@Autowired
	private PizzaService pizzaService;
	
//	@Autowired
//	private PromotingService promotingService;

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("/all")
	public List<Pizza> getAll() {
		
		List<Pizza> pizzaList = pizzaService.findAll();
		
		return pizzaList;
	}
	
	
	@PostMapping("/update/{id}")
	public Pizza updatePizza(
			@PathVariable("id") int id, 
			@Valid @RequestBody Pizza pizza
	) {
		
		Pizza oldPizza = pizzaService.getPizzaById(id).get();
		pizza.setIngredientList(oldPizza.getIngredientList());
		Pizza newPizza = pizzaService.savePizza(pizza);
		
		return newPizza;
	}
	
}
