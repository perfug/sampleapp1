package com.octo.red.newsql;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cache.HashtableCacheProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JpaConfiguration {

	@Value("#{dataSource}")
	private javax.sql.DataSource dataSource;
	
	@Value("#{jpaVendorAdapter}")
	private JpaVendorAdapter jpaVendorAdapter;
	
	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
		return props;
	}


	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager( localContainerEntityManagerFactoryBean().getObject() );
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource);
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		return lef;
	}

}
