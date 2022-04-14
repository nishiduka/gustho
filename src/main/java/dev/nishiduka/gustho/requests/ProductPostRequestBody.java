package dev.nishiduka.gustho.requests;

import lombok.Data;

@Data
public class ProductPostRequestBody {
	private String name;
	private String description;
	private Double quantity;
	private Double price;
	private String metric;
}
