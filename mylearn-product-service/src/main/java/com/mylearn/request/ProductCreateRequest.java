package com.mylearn.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCreateRequest {
	private String title;
	private BigDecimal price;
	private int quantity;
}
