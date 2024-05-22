package com.example.shoppingmall.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.example.shoppingmall.entity.CreditNote;
import com.example.shoppingmall.service.CreditService;

@RestController
@RequestMapping("/credit/note")
public class CreditController {

	@Autowired
	private CreditService creditService;

	@PostMapping("/create")
	public void create(@RequestBody CreditNote note) {
		creditService.save(note);
	}

	@GetMapping("/getById/{id}")
	public Optional<CreditNote> getById(@PathVariable UUID id) {
		return creditService.getById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody CreditNote note) {
		creditService.update(note);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable UUID id) {
		creditService.delete(id);
	}

	@GetMapping("/getByBillNo")
	public List<CreditNote> getByBillNo(@RequestParam(value = "billNumber", required = false) String billNumber) {
		return creditService.getByFilter(billNumber);
	}

}