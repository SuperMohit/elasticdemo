package com.horus.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.horus.document.Transaction;


public interface HorusTransactionService {
	@Transactional
	List<Transaction> getAllTransactions();
	@Transactional
	void saveTransactions();

}
