package com.app.farm.farmApp.service;

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
import com.app.farm.farmApp.repository.FarmRepository;
import com.app.farm.farmApp.service.impl.FarmServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FarmServiceImplTest {

	@InjectMocks
	FarmServiceImpl farmService;
	
	@Mock
	private FarmRepository farmRepository;
	
	@Test
	public void createFarmTest() {
		Farm farm = new Farm();
		Mockito.when(farmRepository.save(farm)).thenReturn(farm);
		Farm resultFarm = farmService.createFarm(farm);
		assertEquals(farm, resultFarm);
	}
	
	@Test
	public void getAllFarmsTest() {
		List<Farm> farmsList = new ArrayList<>();
		Farm farm = new Farm();
		farmsList.add(farm);
		Mockito.when(farmRepository.findAll()).thenReturn(farmsList);
		List<Farm> resultList = farmService.getAllFarms();
		assertEquals(farmsList, resultList);
	}
	
	@Test
	public void getFarmByIdTest() {
		List<Farm> farmsList = new ArrayList<>();
		Farm farm = new Farm();
		farm.setId(1);
		farmsList.add(farm);
		Mockito.when(farmRepository.findAll()).thenReturn(farmsList);
		Farm resultFarm = farmService.getFarmById(1);
		assertEquals(farmsList.get(0), resultFarm);
	}
	
	@Test
	public void deleteFarmTest() {
		Mockito.doNothing().when(farmRepository).deleteById(Mockito.anyInt());
		farmService.deleteFarm(1);
	}
	

}
