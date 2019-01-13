package com.sample.elastic.subcategories;

import java.util.List;

import lombok.Data;

@Data
public class SubCategoryResponse {

	private int status;
	private String message;
	private List<SubCategories> subcategories;
	
}
