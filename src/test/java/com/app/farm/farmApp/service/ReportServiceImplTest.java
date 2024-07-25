package com.app.farm.farmApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.enums.Crop;
import com.app.farm.farmApp.enums.Season;
import com.app.farm.farmApp.service.impl.FarmServiceImpl;
import com.app.farm.farmApp.service.impl.ReportServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {
	
	@InjectMocks
	ReportServiceImpl reportService;
	
	@Mock
	FarmServiceImpl farmService;
	
	@Test
	public void generateFarmReportsTest() {
		List<Farm> farms = new ArrayList<>();
		Farm farm1 = new Farm();
		farm1.setId(1);
		farm1.setName("Farm1");
		List<Field> fields = new ArrayList<>();
		Field field1 = new Field();
		field1.setCrop(Crop.RICE);
		field1.setSeason(Season.SUMMER);
		field1.setActualHarvestedProduct(5000.00);
		field1.setExpectedProduct(10000.00);
		fields.add(field1);
		farm1.setFields(fields);
		farms.add(farm1);
		
		Mockito.when(farmService.getAllFarms()).thenReturn(farms);
		
		Map<Farm,String> resultMap = reportService.generateFarmReports(Season.SUMMER);
		System.out.print(resultMap);
	}
}
