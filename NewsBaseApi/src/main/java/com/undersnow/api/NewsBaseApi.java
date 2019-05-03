package com.undersnow.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

	private static Set<Item> Items = new HashSet<>();

	@GetMapping("addedItems")
	public Set<Item> getItem() {
		Set<Item> mySet = new HashSet<>();
		repo.findAll().forEach(x -> mySet.add(x));
		return mySet;
	}

	@GetMapping("del")
	public Boolean delAll() {
		Set<Item> mySet = new HashSet<>();
		try {
			repo.deleteAll();
			return true;
		} catch (Exception e) {

		}

		return false;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "add")
	public void addItem(@RequestBody Item Item) {
		repo.save(Item);
	}
}
