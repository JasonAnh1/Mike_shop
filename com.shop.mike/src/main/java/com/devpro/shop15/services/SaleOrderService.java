package com.devpro.shop15.services;

import org.springframework.stereotype.Service;

import com.devpro.shop15.entities.SaleOrder;

@Service
public class SaleOrderService extends BaseService<SaleOrder> {

	@Override
	protected Class<SaleOrder> clazz() {
		// TODO Auto-generated method stub
		return SaleOrder.class;
	}

}
