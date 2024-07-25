package com.app.farm.farmApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.farm.farmApp.entity.Farm;
import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.service.FieldService;

@ExtendWith(MockitoExtension.class)
public class FieldControllerTest {
	
	@InjectMocks
	FieldController fieldController;
	
	@Mock
	FieldService fieldService;
	
	@Test
	public void createFieldTest() {
		Field field = new Field();
		Mockito.when(fieldService.createField(Mockito.any())).thenReturn(field);
		fieldController.createField(field);
	}
	
	@Test
	public void getAllFieldssTest() {
		List<Field> fields = new ArrayList<>();
		Field farm = new Field();
		fields.add(farm);
		Mockito.when(fieldService.getAllFields()).thenReturn(fields);
		
		List<Field> resultFields = fieldController.getAllFields();
		assertEquals(fields, resultFields);
	}

	@Test
	public void getFieldByIdTest() {
		Field field = new Field();
		field.setId(1);
		Mockito.when(fieldService.getFieldById(Mockito.anyInt())).thenReturn(field);
		Field resultField = fieldService.getFieldById(1);
		assertEquals(field, resultField);
	}


	@Test
	public void deleteField() {
		Mockito.doNothing().when(fieldService).deleteField(Mockito.anyInt());
		fieldService.deleteField(1);
	}

}
