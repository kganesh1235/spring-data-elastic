package com.sample.elastic.categories;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponse {

	private int status;
	private String message;
	
	private List<Category> categories;
}
