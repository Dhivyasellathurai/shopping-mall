package com.example.shoppingmall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.entity.BinwiseSummary;
import com.example.shoppingmall.service.SummaryService;

@RestController
@RequestMapping("/shopping/mall")
public class SummaryController {

	@Autowired
	private SummaryService summaryService;

	@PostMapping(value = "/create")
	public void create(@RequestBody BinwiseSummary request) {
		summaryService.save(request);
	}

	@GetMapping("/getById/{id}")
	public Optional<BinwiseSummary> findById(@PathVariable int id) {
		return summaryService.getById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody BinwiseSummary request) {
		summaryService.update(request);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		summaryService.deleteById(id);
	}

	@GetMapping("/getByFilters")
	public List<BinwiseSummary> getByFilter(@RequestParam(name = "department", required = false) String department,
			@RequestParam(name = "plant", required = false) String plant,
			@RequestParam(name = "inventoryType", required = false) String inventoryType,
			@RequestParam(name = "reportType", required = false) String reportType,
			@RequestParam(name = "productType", required = false) String productType) {
		return summaryService.getByFilter(department, plant, reportType, productType, inventoryType);
	}

}
