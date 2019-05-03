package com.undersnow.api.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "dbs", type = "item", createIndex = false)
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ALL = -1, HISTORIES = 0, JOKES = 1, PROBLEMS = 2, EXPERIENCES = 3, LIKES = -2;
	public static final int SINGLE = 0, CATEGORY_QUOTES = 1, ALL_QUOTES = 2;
	public static final String TAG_DB_ID = "id", TAG_DB_TEXT = "text", TAG_DB_CAT = "category_id", TAG_DB_DATE = "date",
			TAG_DB_AUTH = "author";

	@Id
	private String id;
	private String description;
	private Date dateCreated;
	private Integer category;
	private Long dbId;

	
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



	public Integer getCategory() {
		return category;
	}



	public void setCategory(Integer category) {
		this.category = category;
	}



	public Long getDbId() {
		return dbId;
	}



	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	
}
