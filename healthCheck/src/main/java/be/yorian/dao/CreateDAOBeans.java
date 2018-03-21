package be.yorian.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = CreateDAOBeans.class)
public class CreateDAOBeans {

	@Autowired
	private DataSource dataSource;

	LocalSessionFactoryBean sessionFactory;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "be.yorian.domain" });
		sessionFactory.getHibernateProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		sessionFactory.getHibernateProperties().put("hibernate.use_sql_comments", true);
		sessionFactory.getHibernateProperties().put("hibernate.globally_quoted_identifiers", "true");
		sessionFactory.getHibernateProperties().put("hibernate.hbm2ddl.auto", "create");
		return sessionFactory;
	}
	
	@Bean(name = "txName")
	public HibernateTransactionManager txName() throws IOException {
		HibernateTransactionManager txName = new HibernateTransactionManager();
		txName.setSessionFactory(sessionFactory.getObject());
		txName.setDataSource(dataSource);
		return txName;
	}
	


}
