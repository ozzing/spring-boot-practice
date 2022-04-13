package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.WebBoard;

public interface CustomCrudRepository extends CrudRepository<WebBoard, Long>, CustomWebBoard{
	
}