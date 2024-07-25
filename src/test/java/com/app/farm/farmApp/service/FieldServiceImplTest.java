package com.app.farm.farmApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.farm.farmApp.entity.Field;
import com.app.farm.farmApp.repository.FieldRepository;
import com.app.farm.farmApp.service.impl.FieldServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FieldServiceImplTest {
	
	@InjectMocks
	FieldServiceImpl fieldService;
	
	@Mock
	private FieldRepository fieldRepository;
	
	@Test
	public void createFarmTest() {
		Field field = new Field();
		Mockito.when(fieldRepository.save(field)).thenReturn(field);
		Field resultField = fieldService.createField(field);
		assertEquals(field, resultField);
	}
	
	@Test
	public void getAllFieldsTest() {
		List<Field> fieldList = new ArrayList<>();
		Field field = new Field();
		fieldList.add(field);
		Mockito.when(fieldRepository.findAll()).thenReturn(fieldList);
		List<Field> resultList = fieldService.getAllFields();
		assertEquals(fieldList, resultList);
	}
	
	@Test
	public void getFieldByIdTest() {
		List<Field> fieldList = new ArrayList<>();
		Field field = new Field();
		field.setId(1);
		fieldList.add(field);
		Mockito.when(fieldRepository.findAll()).thenReturn(fieldList);
		Field resultField = fieldService.getFieldById(1);
		assertEquals(fieldList.get(0), resultField);
	}
	
	@Test
	public void deleteFieldTest() {
		Mockito.doNothing().when(fieldRepository).deleteById(Mockito.anyInt());
		fieldService.deleteField(1);
	}
	
	

}
