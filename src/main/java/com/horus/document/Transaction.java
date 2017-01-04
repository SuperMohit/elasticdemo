package com.horus.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "horus", type = "transactions")
public class Transaction {
	@Id
	private Long transactionId;
	private String description;
	private int horusPEC;
	
	public Transaction(){
		
	}
	
	
	public Transaction(String description, int horusPec) {
		this.horusPEC = horusPec;
		this.description = description;

	}


	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getHorusPEC() {
		return horusPEC;
	}


	public void setHorusPEC(int horusPEC) {
		this.horusPEC = horusPEC;
	}
}
