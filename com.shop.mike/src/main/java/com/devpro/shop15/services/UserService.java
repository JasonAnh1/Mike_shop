package com.devpro.shop15.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.shop15.dto.AccountSearchModel;
import com.devpro.shop15.entities.User;

@Service
public class UserService extends BaseService<User> {

	@Override
	protected Class<User> clazz() {
		// TODO Auto-generated method stub
		return User.class;
	}
	public User loadUserByUsername(String userName) {
		String sql = "select * from tbl_users u where u.username = '" + userName + "'";
		List<User> users = this.runTransactQuerySQL(sql, 0).getData();
		
		if(users == null || users.size() <= 0) return null;
		return users.get(0);
	}
public PagerData<User> search(AccountSearchModel searchModel, int role){
		
		String sql = "select * from tbl_users u join tbl_users_roles ur on u.id = ur.user_id join tbl_roles r on r.id = ur.role_id"
				+ " where r.name = ";
		if(role == 1) {
			sql += "'GUEST'";
		}
		if(role == 2) {
			sql += "'ADMIN'";
		}
//		if(searchModel != null) {	
//			sql += "  " ;
//		}
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}
	

}
