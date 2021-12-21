package com.devpro.shop15.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.devpro.shop15.utils.Contants;

@Configuration // -> đây là 1 BEAN cho loại Cấu hình.
public class MVCConf implements WebMvcConfigurer, Contants  {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:"+UPLOAD_FOLDER_ROOT);
	}
   
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		// thiet lap engine
		bean.setViewClass(JstlView.class);
		// duong dan
		bean.setPrefix("/WEB-INF/views/");
		//
		bean.setSuffix(".jsp");
		return bean;
	}
}
