package com.sample.elastic.categories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.elastic.service.QueryDSLService;

@RestController
@RequestMapping("categories")
public class CategoriesController {

	private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	private QueryDSLService service;

	@GetMapping("")
	public ResponseEntity<CategoryResponse> getCategories() {
		CategoryResponse categoryResponse = new CategoryResponse();

		try {

			categoryResponse.setStatus(200);
			categoryResponse.setMessage("Request Processed successfully");
//			categoryResponse.setCategories(categories);
			return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

		} catch (Exception e) {
			logger.error(e.getMessage());
			categoryResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			categoryResponse.setMessage(e.getMessage());
			return new ResponseEntity<>(categoryResponse, HttpStatus.BAD_REQUEST);
		}
	}
}
