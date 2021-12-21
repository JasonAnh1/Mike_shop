package com.devpro.shop15.services;

import org.springframework.stereotype.Service;

import com.devpro.shop15.entities.Role;

@Service
public class RoleService extends BaseService<Role> {

	@Override
	protected Class<Role> clazz() {
		// TODO Auto-generated method stub
		return Role.class;
	}



}
