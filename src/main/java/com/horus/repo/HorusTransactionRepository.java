package com.horus.repo;

import java.util.stream.Stream;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.horus.document.Transaction;

public interface HorusTransactionRepository
		extends ElasticsearchRepository<Transaction, Long> {
	
	


}
