package com.app.farm.farmApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.service.FieldService;

@RestController
@RequestMapping("/farms/{farmId}/fields")
public class FieldController {

	@Autowired
	private FieldService fieldService;

	@PostMapping("createField")
	public Field createField(@RequestBody Field field) {
		return fieldService.createField(field);
	}

	@GetMapping("getAllFields")
	public List<Field> getAllFields() {
		return fieldService.getAllFields();
	}

	@GetMapping("getFieldById/{fieldId}")
	public Field getFieldById(@PathVariable Integer fieldId) {
		return fieldService.getFieldById(fieldId);
	}

	@PutMapping("updateField/{fieldId}")
	public Field updateField(@PathVariable Integer fieldId, @RequestBody Field field) {
		return fieldService.updateField(fieldId, field);
	}

	@DeleteMapping("deleteField/{fieldId}")
	public void deleteField(@PathVariable Integer fieldId) {
		fieldService.deleteField(fieldId);
	}
}
