package com.undersnow.api.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.undersnow.api.model.Item; 

public interface ItemRepository extends ElasticsearchCrudRepository< Item ,String > {
 
}
