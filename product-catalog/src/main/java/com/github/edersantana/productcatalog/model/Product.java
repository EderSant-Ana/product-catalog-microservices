package com.github.edersantana.productcatalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "product") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	private Long id;
	private String name;
	private Integer amount;
		

}
