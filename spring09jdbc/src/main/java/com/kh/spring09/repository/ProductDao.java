package com.kh.spring09.repository;

import java.util.List;

import com.kh.spring09.entity.ProductDto;

public interface ProductDao {
	void insert(ProductDto productDto);

	List<ProductDto> list();
}
