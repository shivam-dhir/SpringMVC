package com.shivam.SpringMVC;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Integer>{
	
	// functions with prefix 'findBy' are provided by JpaRepository interface. Camelcasing has to be strictly followed.
	// there are similar functionalities like 'findBy' provided by JpaRepository with other prefixes
	// Parameter with first letter capitalized should be suffix
	// findByNameOrderByIdDesc : Name -> variable name with first letter capitalized
	// OrderById: OrderBy is used to sort result according to Id which is another parameter with first letter capitalized.
	// OrderByMetascore: sorting is done according to the metascore of the objects. Note how first letter of metascore is capitalized.
	// Desc means sorting should be done in descending order. Not adding Desc would default to ascending order
	public List<Game> findByName(String name); // no sorting
	public List<Game> findByNameOrderByMetascore(String name); // default sorting (ascending) according to metascore
	public List<Game> findByNameOrderByMetascoreDesc(String name); // sorting according to metascore in descending order
}
