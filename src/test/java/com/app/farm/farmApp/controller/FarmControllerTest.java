package com.app.farm.farmApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.service.FarmService;

@ExtendWith(MockitoExtension.class)
public class FarmControllerTest {
	
	@InjectMocks
	FarmController farmController;
	
	@Mock
	FarmService farmService;
	
	@Test
	public void createFarmTest() {
		Farm farm = new Farm();
		Mockito.when(farmService.createFarm(Mockito.any())).thenReturn(farm);
		farmController.createFarm(farm);
	}
	
	@Test
	public void getAllFarmsTest() {
		List<Farm> farms = new ArrayList<>();
		Farm farm = new Farm();
		farms.add(farm);
		Mockito.when(farmService.getAllFarms()).thenReturn(farms);
		
		List<Farm> resultFarms = farmController.getAllFarms();
		assertEquals(farms, resultFarms);
	}

	@Test
	public void getFarmByIdTest() {
		Farm farm = new Farm();
		farm.setId(1);
		Mockito.when(farmService.getFarmById(Mockito.anyInt())).thenReturn(farm);
		Farm resultFarm = farmService.getFarmById(1);
		assertEquals(farm, resultFarm);
	}


	@Test
	public void deleteFarm() {
		Mockito.doNothing().when(farmService).deleteFarm(Mockito.anyInt());
		farmService.deleteFarm(1);
	}
	
	

}
