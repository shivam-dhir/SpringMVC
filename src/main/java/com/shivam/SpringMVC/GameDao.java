package com.shivam.SpringMVC;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameDao extends JpaRepository<Game, Integer>{
	
	// functions with prefix 'findBy' are provided by JpaRepository interface. Camelcasing has to be strictly followed.
	// there are similar functionalities like 'findBy', 'OrderBy' etc. provided by JpaRepository with other prefixes
	// Parameter with first letter capitalized should be suffix
	// findByNameOrderByIdDesc : Name -> variable name with first letter capitalized
	// OrderById: OrderBy is used to sort result according to Id which is another parameter with first letter capitalized.
	// OrderByMetascore: sorting is done according to the metascore of the objects. Note how first letter of metascore is capitalized.
	// Desc means sorting should be done in descending order. Not adding Desc would default to ascending order
	List<Game> findByName(String name); // no sorting
	List<Game> findByNameOrderByMetascore(String name); // default sorting (ascending) according to metascore
	List<Game> findByNameOrderByMetascoreDesc(String name); // sorting according to metascore in descending order
	
	// @Query -> custom HQL query written by developer. Can be used to write complex queries not given by JpaRepository.
	// Colon(:) specifies the value. Here gameName will be replaced by the value which is stored in variable gameName. 
	// We assign the parameter name to gameName by using @Param annotation.
	@Query("from Game where name = :gameName")
	List<Game> find(@Param("gameName") String name);	 
}
