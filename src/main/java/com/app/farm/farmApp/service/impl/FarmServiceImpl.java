package com.app.farm.farmApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.repository.FarmRepository;
import com.app.farm.farmApp.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService{
	
	@Autowired
	private FarmRepository farmRepository;

	@Override
	public Farm createFarm(Farm farm) {
		farmRepository.save(farm);
		return farm;
	}

	@Override
	public List<Farm> getAllFarms() {
		return farmRepository.findAll();
	}

	@Override
	public Farm getFarmById(Integer id) {
		return farmRepository.findAll().stream().filter(farm -> farm.getId().equals(id)).findFirst()
				.orElseThrow(() -> new RuntimeException("Farm not found with id " + id));
	}

	@Override
	public Farm updateFarm(Integer id, Farm farm) {
		Farm identifiedFarm = farmRepository.findById(id).get();
		identifiedFarm.setName(farm.getName());
		identifiedFarm.setFields(farm.getFields());
		farmRepository.save(identifiedFarm);
		return identifiedFarm;
	}

	@Override
	public void deleteFarm(Integer id) {
		farmRepository.deleteById(id);
	}

}
