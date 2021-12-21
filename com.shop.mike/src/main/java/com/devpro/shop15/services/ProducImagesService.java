package com.devpro.shop15.services;

import org.springframework.stereotype.Service;

import com.devpro.shop15.entities.ProductImages;

@Service
public class ProducImagesService extends BaseService<ProductImages> {

	@Override
	protected Class<ProductImages> clazz() {
		// TODO Auto-generated method stub
		return ProductImages.class;
	}

}
