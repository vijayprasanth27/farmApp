package com.app.farm.farmApp.service;

import java.util.Map;

public interface ReportService {
	Map<String, String> generateFarmReports(String season);
	Map<String, String> generateCropReports(String season);
}
