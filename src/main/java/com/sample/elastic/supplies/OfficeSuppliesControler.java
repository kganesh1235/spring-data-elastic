package com.sample.elastic.supplies;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.elastic.repository.OfficeSuppliesRepository;

@RestController
@RequestMapping("supplies")
public class OfficeSuppliesControler {

	private static final Logger logger = LoggerFactory.getLogger(OfficeSuppliesControler.class);

	@Autowired
	private OfficeSuppliesRepository officeSuppliesRepository;

	@PostMapping("add")
	public ResponseEntity<OfficeSuppliesResponse> add(@RequestBody OfficeSupplies officeSupplies) {
		OfficeSuppliesResponse OfficeSuppliesResponse = new OfficeSuppliesResponse();
		logger.info("student register process started");
		try {

			officeSuppliesRepository.save(officeSupplies);
			OfficeSuppliesResponse.setStatus(200);
			OfficeSuppliesResponse.setMessage("Request Processed successfully");

			return new ResponseEntity<>(OfficeSuppliesResponse, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			OfficeSuppliesResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			OfficeSuppliesResponse.setMessage(e.getMessage());
			return new ResponseEntity<>(OfficeSuppliesResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("all")
	public ResponseEntity<OfficeSuppliesResponse> all() {
		OfficeSuppliesResponse officeSuppliesResponse = new OfficeSuppliesResponse();
		logger.info("student register process started");
		try {

			Iterable<OfficeSupplies> supplies = officeSuppliesRepository.findAll();
			officeSuppliesResponse.setStatus(200);
			officeSuppliesResponse.setMessage("Request Processed successfully");
			officeSuppliesResponse
					.setSupplies(StreamSupport.stream(supplies.spliterator(), false).collect(Collectors.toList()));

			return new ResponseEntity<>(officeSuppliesResponse, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			officeSuppliesResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			officeSuppliesResponse.setMessage(e.getMessage());
			return new ResponseEntity<>(officeSuppliesResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
