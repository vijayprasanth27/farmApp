package com.app.farm.farmApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.farm.farmApp.entity.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer>{

}
