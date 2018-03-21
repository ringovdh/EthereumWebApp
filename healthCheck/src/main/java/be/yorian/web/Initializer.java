package be.yorian.web;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import be.yorian.dao.CreateDAOBeans;
import be.yorian.datasource.CreateDataSourceBean;
import be.yorian.security.CreateSecurityFilter;
import be.yorian.services.CreateServiceBeans;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { CreateDataSourceBean.class, CreateDAOBeans.class, CreateServiceBeans.class, CreateSecurityFilter.class };
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { CreateControllerBeans.class };
	}

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		context.setAttribute("contextPath", context.getContextPath());
		super.onStartup(context);
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();
		utf8Filter.setEncoding("UTF-8");
		return new Filter[] { utf8Filter };
	}
}
