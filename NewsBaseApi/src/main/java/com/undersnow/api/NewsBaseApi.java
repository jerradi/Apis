package com.undersnow.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.undersnow.api.model.Item;
import com.undersnow.api.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(exclude = { ElasticsearchAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class })
public class NewsBaseApi {

	public static void main(String[] args) {
		SpringApplication.run(NewsBaseApi.class, args);
	}

}

/**
 * 
 * @author undersnow
 *
 */
@Slf4j
@RestController
class PublicController {

	@Autowired
	private ItemRepository repo;
	private static long counter = -1;
	@GetMapping("addedItems")
	public Set<Item> getItem() {
		Set<Item> mySet = new HashSet<>();
		repo.findAll().forEach(x -> mySet.add(x));
		return mySet;
	}
	
	
	@GetMapping("since/{id}")
	public Set<Item> getItemSince(@PathVariable("id") Long id) {
		Set<Item> mySet = new HashSet<>();
		repo.findSince(id).forEach(x -> mySet.add(x));
		return mySet;
	}

	@GetMapping("del")
	public Boolean delAll() {
		try {
			repo.deleteAll();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "add")
	public void addItem(@RequestBody  @DateTimeFormat(pattern = "dd-MM-yyyy") Item item) {
		
		item.setDbId( (counter>0?counter:(counter=(int)repo.count())));
		repo.save(item);
		counter++;
	}
}
