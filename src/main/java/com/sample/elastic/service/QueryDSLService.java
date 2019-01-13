package com.sample.elastic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryDSLService {

	@Autowired
	private ElasticsearchTemplate template;
}
