package com.app.farm.farmApp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.farm.farmApp.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/generateFarmReport/{season}")
	public Map<String, String> getFarmById(@PathVariable String season) {
		return reportService.generateFarmReports(season);
	}

	@GetMapping("/generateCropReport/{season}")
	public Map<String, String> getCropById(@PathVariable String season) {
		return reportService.generateCropReports(season);
	}
}
