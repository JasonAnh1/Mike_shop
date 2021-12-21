package com.devpro.shop15.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devpro.shop15.components.Utilities;
import com.devpro.shop15.dto.CategorySearchModel;
import com.devpro.shop15.entities.Categories;
@Service
public class CategoryService extends BaseService<Categories> {

	@Override
	protected Class<Categories> clazz() {
		// TODO Auto-generated method stub
		return Categories.class;
	}
	public PagerData<Categories> search(CategorySearchModel searchModel)
	{
		String sql = "SELECT * FROM tbl_category c WHERE 1=1";
		
		if (searchModel != null)
		{		
			if(!StringUtils.isEmpty(searchModel.getSeo())) {
				sql += " and c.seo ='" + searchModel.getSeo() + "'";
			}	
		}
		
		
		return runTransactQuerySQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}
	public Categories add(Categories p) {
		
		
		p.setSeo(Utilities.slugify(p.getName()));
		return super.saveOrUpdate(p);
	}
public Categories update(Categories p) {
		
		
		p.setSeo(Utilities.slugify(p.getName()));
		return super.saveOrUpdate(p);
	}
	
	
	
	
}
