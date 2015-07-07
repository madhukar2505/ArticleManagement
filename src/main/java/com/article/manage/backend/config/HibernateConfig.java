package com.article.manage.backend.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/am");
		// source.setUrl("jdbc:mysql://localhost:3306/feastexp_dev20aug");
		source.setUsername("root");
		source.setPassword("9sum5is14");
		return source;
	}

	@Bean
	public AnnotationSessionFactoryBean getAnnotationSessionFactoryBean() {
		AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
		bean.setDataSource(getDriverManagerDataSource());

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		// commented on 11th sept:sudhir
		// hibernateProperties.setProperty("hibernate.show_sql", "true");
		// hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		bean.setHibernateProperties(hibernateProperties);
		// String[] annotatedPackages = {"com.fe.model.db"};
		@SuppressWarnings("rawtypes")
		Class[] annotatedClasses = { };
		bean.setAnnotatedClasses(annotatedClasses);
		// bean.setAnnotatedPackages(annotatedPackages);
		// String[] annotatedPackages= {"com.fe.model.db"};
		// bean.setAnnotatedPackages(annotatedPackages);
		return bean;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate bean = new HibernateTemplate();
		bean.setSessionFactory(getAnnotationSessionFactoryBean().getObject());
		return bean;
	}

	@Bean(name = "transactionManager")
	HibernateTransactionManager getHibernateTransactionManager() {
		return new HibernateTransactionManager(
				getAnnotationSessionFactoryBean().getObject());
	}

}
