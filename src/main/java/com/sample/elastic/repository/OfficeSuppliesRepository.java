package com.sample.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.elastic.supplies.OfficeSupplies;

@Repository
public interface OfficeSuppliesRepository extends ElasticsearchCrudRepository<OfficeSupplies, Integer> {

}
