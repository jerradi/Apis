package com.undersnow.api.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.undersnow.api.model.Item; 

public interface ItemRepository extends ElasticsearchCrudRepository< Item ,String > {

	

	@Query("	{\"range\" : {\"dbId\" : {\"gte\" : ?0}}}")
	Iterable<Item> findSince(long id);
 
}
