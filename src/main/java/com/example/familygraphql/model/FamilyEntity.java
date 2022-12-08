package com.example.familygraphql.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLInputField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="family")
public class FamilyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GraphQLId
	private Long id;
	
	@Column(name="surname")
	@GraphQLInputField
	private String surname;

	@Column
	@GraphQLInputField
	private String name; //(name="name") можно не указывать, если название совпадает с названием поля

	@GraphQLInputField
	private String fathername; //Column и (name="fathername") можно не указывать, если название совпадает с названием поля

	@Column
	@GraphQLInputField
	private LocalDate birthday;
}