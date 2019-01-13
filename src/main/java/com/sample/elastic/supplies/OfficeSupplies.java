package com.sample.elastic.supplies;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "office_supplies", type = "product", shards = 2)
public class OfficeSupplies {

	@Id
	private String id;
	private String category;
	private String sub_category;
	private String brand;
	private String model;
	private String description;
	private Float price;
}
