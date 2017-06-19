package com.hidroplan.application.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ImportResource({ "classpath:environment.xml" })
@EnableTransactionManagement (mode=AdviceMode.PROXY,  proxyTargetClass = false)
@EnableJpaRepositories(basePackages = "com.hidroplan.persistence.consolidation", entityManagerFactoryRef = "portfolioEntityManager", transactionManagerRef = "portfolioTransactionManager")
@ComponentScan("com.hidroplan.persistence.consolidation")
public class HidroplanPersistenceConfig implements TransactionManagementConfigurer {
	@Value("${hidroplan-datasource}") private String datasource;
	@Value("${hidroplan-jdbc-dialect}") private String dialect;
	@Value("${hidroplan-hibernate-database-type}") private String hibernateDatabaseType;
	@Value("${hidroplan-hibernate-show-sql}") private String hibernateShowSql;
	@Value("${hidroplan-hibernate-generate-ddl}") private String hibernateGenerateDdl;

	@Bean
	public DataSource consolidationDataSource() {
		JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		jndiDataSourceLookup.setResourceRef(true);

		return jndiDataSourceLookup.getDataSource(datasource);
	}

	@Bean
	public HibernateJpaVendorAdapter consolidationVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.valueOf(hibernateDatabaseType));
		vendorAdapter.setShowSql(Boolean.valueOf(hibernateShowSql));

		return vendorAdapter;
	}

	@Bean
	public Properties consolidationProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", dialect);
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", hibernateGenerateDdl);
		jpaProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		jpaProperties.setProperty("hibernate.show_sql", "false");
		jpaProperties.setProperty("hibernate.format_sql", "false");
		jpaProperties.setProperty("hibernate.use_sql_comments", "false");
		jpaProperties.setProperty("hibernate.use_outer_join", "true");
		jpaProperties.setProperty("hibernate.default_batch_fetch_size", "16");
		jpaProperties.setProperty("hibernate.max_fetch_depth", "3");

		jpaProperties.setProperty("hibernate.transaction.flush_before_completion", "true");
		jpaProperties.setProperty("hibernate.current_session_context_class", "managed");
		jpaProperties.setProperty("hibernate.generate_statistics","false");
		jpaProperties.setProperty("hibernate.cache.use_minimal_puts", "true");
		jpaProperties.setProperty("hibernate.cache.use_query_cache", "true");
		jpaProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
		jpaProperties.setProperty("hibernate.cache.use_structured_entries", "true");
		jpaProperties.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
		jpaProperties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
//		jpaProperties.setProperty("net.sf.ehcache.configurationResourceName", "/ehcache.xml");
		jpaProperties.setProperty("hibernate.connection.release_mode","after_transaction");
		jpaProperties.setProperty("hibernate.transaction.auto_close_session","true");
		jpaProperties.setProperty("jboss.as.jpa.providerModule", "application");
		jpaProperties.setProperty("jboss.as.jpa.managed", "false");

		return jpaProperties;
	}

	@Bean
	public PlatformTransactionManager portfolioTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setFailEarlyOnGlobalRollbackOnly(true);
		transactionManager.setEntityManagerFactory(portfolioEntityManager().getObject());
		return transactionManager;
	}

	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(portfolioTransactionManager());
	}


	@Bean
	public LocalContainerEntityManagerFactoryBean portfolioEntityManager() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(consolidationDataSource());
		factory.setPackagesToScan("com.hidroplan.persistence.consolidation");
		factory.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
		factory.setJpaVendorAdapter(consolidationVendorAdapter());
		factory.setJpaProperties(consolidationProperties());

		return factory;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return portfolioTransactionManager();
	}

}
