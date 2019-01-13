package com.sample.elastic.supplies;


import java.util.List;

import lombok.Data;

@Data
public class OfficeSuppliesResponse {

	private int status;
	private String message;

	private List<OfficeSupplies> supplies;
}
