package com.sample.elastic.subcategories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subcategories")
public class SubCategoriesController {

	private static final Logger logger = LoggerFactory.getLogger(SubCategoriesController.class);

	@GetMapping("")
	public ResponseEntity<SubCategoryResponse> getCategories() {
		SubCategoryResponse subCategoryResponse = new SubCategoryResponse();

		try {

			return null;

		} catch (Exception e) {
			logger.error(e.getMessage());
			subCategoryResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			subCategoryResponse.setMessage(e.getMessage());
			return new ResponseEntity<>(subCategoryResponse, HttpStatus.BAD_REQUEST);
		}
	}
}
