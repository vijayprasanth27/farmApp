package com.app.farm.farmApp.service;

import java.util.List;

import com.app.farm.farmApp.entity.Farm;

public interface FarmService {
	Farm createFarm(Farm farm);
	List<Farm> getAllFarms();
	Farm getFarmById(Integer id);
	Farm updateFarm(Integer id, Farm farm);
	void deleteFarm(Integer id);
}
