package com.horus.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horus.document.Transaction;
import com.horus.repo.HorusTransactionRepository;

@Service
public class HorusTransactionServiceImpl implements HorusTransactionService {
	@Autowired
	HorusTransactionRepository horusRepository;

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		Iterable<Transaction> iTransactions = horusRepository.findAll();
		
		if (iTransactions != null)
			for (Transaction transaction : horusRepository.findAll())
				transactions.add(transaction);
		
		return transactions;
	}

	@Override
	public void saveTransactions() {
		cleanBeforeSaving();
		saveAll();
	}

	private void cleanBeforeSaving() {
		horusRepository.deleteAll();
	}

	private void saveAll() {
		horusRepository.save(new Transaction("Rejected", 1234568890));
		horusRepository.save(new Transaction("Synchronised", 1234568891));
		horusRepository.save(new Transaction("Ineligible", 1234568892));
		horusRepository.save(new Transaction("Awaiting COL", 1234568893));
	}

}
