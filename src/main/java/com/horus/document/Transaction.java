package com.horus.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Document(indexName = "horus", type = "transactions")
@Data
public class Transaction {
	@Id
	private Long transactionId;
	private String description;
	private int horusPEC;
	
	public Transaction(String description, int horusPec) {
		this.horusPEC = horusPec;
		this.description = description;

	}
}
