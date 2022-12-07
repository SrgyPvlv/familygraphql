package com.example.familygraphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.familygraphql.exeption.FamilyNotFoundExeption;
import com.example.familygraphql.model.FamilyEntity;
import com.example.familygraphql.repository.FamilyRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FamilyController {

	private final FamilyRepository familyRepository;
	
	@QueryMapping
	public List<FamilyEntity> findAllFamilies(){
		return familyRepository.findAll();
	}
	
	@MutationMapping
	public FamilyEntity createFamily(@Argument String surname,@Argument String name,@Argument String fathername) {
		FamilyEntity family=new FamilyEntity();
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	@MutationMapping
	public FamilyEntity updateFamily(@Argument Long id,@Argument String surname,@Argument String name,@Argument String fathername){
		
		FamilyEntity family=familyRepository.findById(id).orElseThrow(()->new FamilyNotFoundExeption("Not found FamilyEntity to update!"));
		
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	@MutationMapping
	public boolean deleteFamily(@Argument Long id) {
		familyRepository.deleteById(id);
		
		return true;
	}
}
