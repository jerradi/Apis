package com.undersnow.api.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "urls", type = "quote")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ALL = -1, HISTORIES = 0, JOKES = 1, PROBLEMS = 2, EXPERIENCES = 3, LIKES = -2;
	public static final int SINGLE = 0, CATEGORY_QUOTES = 1, ALL_QUOTES = 2;
	public static final String TAG_DB_ID = "id", TAG_DB_TEXT = "text", TAG_DB_CAT = "category_id", TAG_DB_DATE = "date",
			TAG_DB_AUTH = "author";

	@Override
	public String toString() {
		return "Item{" + "id=" + like + ", description='" + description + '\'' + '}';
	}

	
 
	private Long id;

	private String description;

	 private Date dateCreated;

	private int type;

	private boolean like;

	private int category;  
	private Integer dbId;

 

	public Item() {
		dateCreated =  new Date();
	}

	public Item(String desc, int type) {
		dateCreated =  new Date();
		this.type = type;
		this.category = 4;
		this.description = desc; 
	}

	public Item(String description, int type, int category) {
		this.description = description; 
		dateCreated =  new Date();
	}

	public Integer getDbId() {
		return dbId;
	}

	public void setDbId(Integer dbId) {
		this.dbId = dbId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	 
}
