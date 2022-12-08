package com.example.familygraphql.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.familygraphql.exeption.FamilyNotFoundExeption;
import com.example.familygraphql.model.FamilyEntity;
import com.example.familygraphql.repository.FamilyRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@GraphQLApi
public class FamilyController {

	private final FamilyRepository familyRepository;
	
	@GraphQLQuery(name="findAllFamilies")
	public List<FamilyEntity> findAllFamilies(){
		return familyRepository.findAll();
	}
	
	@GraphQLMutation
	public FamilyEntity createFamily(@GraphQLArgument(name="surname") String surname,@GraphQLArgument(name="name") String name,
			@GraphQLArgument(name="fathername") String fathername) {
		FamilyEntity family=new FamilyEntity();
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	@GraphQLMutation
	public FamilyEntity updateFamily(@GraphQLArgument(name="id") Long id,@GraphQLArgument(name="surname") String surname,
			@GraphQLArgument(name="name") String name,
			@GraphQLArgument(name="fathername") String fathername){
		
		FamilyEntity family=familyRepository.findById(id).orElseThrow(()->new FamilyNotFoundExeption("Not found FamilyEntity to update!"));
		
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	@GraphQLMutation
	public boolean deleteFamily(@GraphQLArgument(name="id") Long id) {
		familyRepository.deleteById(id);
		
		return true;
	}
}
