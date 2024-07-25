package com.app.farm.farmApp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.enums.Crop;
import com.app.farm.farmApp.enums.Season;
import com.app.farm.farmApp.service.FarmService;
import com.app.farm.farmApp.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private FarmService farmService;

	@Override
	public Map<Farm, String> generateFarmReports(Season season) {
		Map<Farm, String> farmReports = new HashMap<>();
		List<Farm> farms = farmService.getAllFarms();
		for (Farm farm : farms) {
			double expectedProduct = farm.getFields().stream().filter(field -> field.getSeason().equals(season)).filter(field -> Objects.nonNull(field.getCrop())).mapToDouble(Field::getExpectedProduct).sum();
			double actualHarvestedProduct = farm.getFields().stream().filter(field -> field.getSeason().equals(season)).filter(field -> Objects.nonNull(field.getCrop())).mapToDouble(Field::getActualHarvestedProduct).sum();
			farmReports.put(farm, "expected :"  +  Double.toString(expectedProduct) + "/" + "actual :" + Double.toString(actualHarvestedProduct));
		}
		return farmReports;
	}

	@Override
	public Map<Crop, String> generateCropReports(Season season) {
		Map<Crop, String> cropReports = new HashMap<>();
		for (Crop crop : Crop.values()) {
			double expectedProduct = farmService.getAllFarms().stream().flatMap(farm -> farm.getFields().stream()).filter(field -> field.getCrop().equals(crop)).filter(field -> field.getSeason().equals(season)).mapToDouble(Field::getExpectedProduct).sum();
			double actualHarvestedProduct = farmService.getAllFarms().stream().flatMap(farm -> farm.getFields().stream()).filter(field -> field.getCrop().equals(crop)).filter(field -> field.getSeason().equals(season)).mapToDouble(Field::getActualHarvestedProduct).sum();
			cropReports.put(crop,  "expected :"  +  Double.toString(expectedProduct) + "/" + "actual :" + Double.toString(actualHarvestedProduct));
		}
		return cropReports;
	}
}
