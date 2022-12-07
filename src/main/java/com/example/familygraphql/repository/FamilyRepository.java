package com.example.familygraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.familygraphql.model.FamilyEntity;


@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Long> {

}
