package com.example.familygraphql.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long id;
	
	@Column(name="surname")
	private String surname;

	@Column
	private String name; //(name="name") можно не указывать, если название совпадает с названием поля

	private String fathername; //Column и (name="fathername") можно не указывать, если название совпадает с названием поля

	@Column
	private LocalDate birthday;
}