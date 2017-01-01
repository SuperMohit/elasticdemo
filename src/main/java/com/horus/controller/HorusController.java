package com.horus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horus.document.Transaction;
import com.horus.service.HorusTransactionService;

@RestController
public class HorusController {
	@Autowired
	HorusTransactionService horusTransactionService;
	
	@GetMapping("/")
	public List<Transaction> getAllTransactions() {
		return horusTransactionService.getAllTransactions();
	}
	
	@GetMapping("/save")
	public void saveTransactions() {
	}
	
}
