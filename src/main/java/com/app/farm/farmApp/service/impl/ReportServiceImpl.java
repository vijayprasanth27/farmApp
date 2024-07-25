package com.app.farm.farmApp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.service.FarmService;
import com.app.farm.farmApp.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private FarmService farmService;

	@Override
	public Map<String, String> generateFarmReports(String season) {
		Map<String, String> farmReports = new HashMap<>();
		List<Farm> farms = farmService.getAllFarms();
		for (Farm farm : farms) {
			Map<String, List<Field>> farmMap = farm.getFields().stream().filter(field -> field.getSeason().equals(season)).filter(field -> Objects.nonNull(field.getCrop())).collect(Collectors.groupingBy(field -> field.getFarm().getName()));
			farmMap.entrySet().stream().forEach(item ->{
				double actualHarvestedProduct = item.getValue().stream().mapToDouble(Field::getActualHarvestedProduct).sum();
				double expectedProduct = item.getValue().stream().mapToDouble(Field::getExpectedProduct).sum();
				farmReports.put(item.getKey(), "expected :"  +  Double.toString(expectedProduct) + "/" + "actual :" + Double.toString(actualHarvestedProduct));
			});
		}
		return farmReports;
	}

	@Override
	public Map<String, String> generateCropReports(String season) {
		Map<String, String> cropReport = new HashMap<>();
		List<Farm> farms = farmService.getAllFarms();
		for (Farm farm : farms) {
			Map<String, List<Field>> cropMap = farm.getFields().stream().filter(field -> field.getSeason().equals(season)).filter(field -> Objects.nonNull(field.getCrop())).collect(Collectors.groupingBy(field -> field.getCrop()));
			cropMap.entrySet().stream().forEach(item ->{
				double actualHarvestedProduct = item.getValue().stream().mapToDouble(Field::getActualHarvestedProduct).sum();
				double expectedProduct = item.getValue().stream().mapToDouble(Field::getExpectedProduct).sum();
				cropReport.put(item.getKey(), "expected :"  +  Double.toString(expectedProduct) + "/" + "actual :" + Double.toString(actualHarvestedProduct));
			});
		}
		return cropReport;
	}
}
