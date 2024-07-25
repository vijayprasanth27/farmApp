package com.app.farm.farmApp.service;

import java.util.Map;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.enums.Crop;
import com.app.farm.farmApp.enums.Season;

public interface ReportService {
	Map<Farm, String> generateFarmReports(Season season);
	Map<Crop, String> generateCropReports(Season season);
}
