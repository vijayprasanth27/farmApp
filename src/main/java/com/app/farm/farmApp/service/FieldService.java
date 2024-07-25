package com.app.farm.farmApp.service;

import java.util.List;

import com.app.farm.farmApp.entity.Field;

public interface FieldService {

	Field createField(Field field);
	List<Field> getAllFields();
	Field getFieldById(Integer id);
	Field updateField(Integer id, Field field);
	void deleteField(Integer id);
}
