package com.app.farm.farmApp.entity;

import com.app.farm.farmApp.enums.Crop;
import com.app.farm.farmApp.enums.Season;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Field {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
	
    private Double plantedArea;
    
    private Crop crop;
    
    private Season season;
    
    private Double expectedProduct;
    
    private Double actualHarvestedProduct;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPlantingArea() {
		return plantedArea;
	}

	public void setPlantingArea(Double plantingArea) {
		this.plantedArea = plantingArea;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Double getExpectedProduct() {
		return expectedProduct;
	}

	public void setExpectedProduct(Double expectedProduct) {
		this.expectedProduct = expectedProduct;
	}

	public Double getActualHarvestedProduct() {
		return actualHarvestedProduct;
	}

	public void setActualHarvestedProduct(Double actualHarvestedProduct) {
		this.actualHarvestedProduct = actualHarvestedProduct;
	}

    
}

