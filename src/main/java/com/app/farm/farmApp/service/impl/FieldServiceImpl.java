package com.app.farm.farmApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.repository.FieldRepository;
import com.app.farm.farmApp.service.FieldService;

@Service
public class FieldServiceImpl implements FieldService{
	
	@Autowired
	private FieldRepository fieldRepository;

	@Override
	public Field createField(Field field) {
		fieldRepository.save(field);
		return field;
	}

	@Override
	public List<Field> getAllFields() {
		return fieldRepository.findAll();
	}

	@Override
	public Field getFieldById(Integer id) {
		return fieldRepository.findAll().stream()
				.filter(field -> field.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Field not found with id " + id));
	}

	@Override
	public Field updateField(Integer id, Field field) {
		Optional<Field> existingField = fieldRepository.findById(id);
		existingField.get().setSeason(field.getSeason());
		existingField.get().setCrop(field.getCrop());
		existingField.get().setPlantingArea(field.getPlantingArea());
		existingField.get().setExpectedProduct(field.getExpectedProduct());
		existingField.get().setActualHarvestedProduct(field.getActualHarvestedProduct());
		fieldRepository.save(existingField.get());
		return existingField.get();
	}

	@Override
	public void deleteField(Integer id) {
		fieldRepository.deleteById(id);
	}
}
