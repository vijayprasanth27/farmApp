package com.app.farm.farmApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.service.FarmService;

@RestController
@RequestMapping("/farms")
public class FarmController {

	@Autowired
    private FarmService farmService;
	
	@PostMapping
	public Farm createFarm(@RequestBody Farm farm) {
		return farmService.createFarm(farm);
	}

	@GetMapping
	public List<Farm> getAllFarms() {
		return farmService.getAllFarms();
	}

	@GetMapping("/{id}")
	public Farm getFarmById(@PathVariable Integer id) {
		return farmService.getFarmById(id);
	}

	@PutMapping("/{id}")
	public Farm updateFarm(@PathVariable Integer id, @RequestBody Farm farm) {
		return farmService.updateFarm(id, farm);
	}

	@DeleteMapping("/{id}")
	public void deleteFarm(@PathVariable Integer id) {
		farmService.deleteFarm(id);
	}
}
