package com.app.farm.farmApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Field {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
	
    private Double plantedArea;
    
    private String crop;
    
    private String season;
    
    private Double expectedProduct;
    
    private Double actualHarvestedProduct;
    
    @ManyToOne
    private Farm farm;
    
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

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Double getPlantedArea() {
		return plantedArea;
	}

	public void setPlantedArea(Double plantedArea) {
		this.plantedArea = plantedArea;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
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

