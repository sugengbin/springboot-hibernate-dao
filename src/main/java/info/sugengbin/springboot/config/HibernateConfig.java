package info.sugengbin.springboot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 *
 * Date:     2017年2月24日<br/> 
 * @author   sugengbin
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:jdbc.properties" })
public class HibernateConfig {

	@Autowired
	private Environment env;

	/**
	 * Initialize druid dataSource
	 * 
	 * @return DataSource
	 */
	@Bean
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
		dataSource.setUrl(env.getRequiredProperty("datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("datasource.username"));
		dataSource.setPassword(env.getRequiredProperty("datasource.password"));
		dataSource.setMaxActive(Integer.parseInt(env.getRequiredProperty("maxActive")));
		dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty("initialSize")));
		dataSource.setMaxWait(Long.parseLong(env.getRequiredProperty("maxWait")));
		dataSource.setMinIdle(Integer.parseInt(env.getRequiredProperty("minIdle")));
		dataSource.setValidationQuery(env.getRequiredProperty("validationQuery"));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getRequiredProperty("testOnBorrow")));
		dataSource.setTestOnReturn(Boolean.parseBoolean(env.getRequiredProperty("testOnReturn")));
		dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getRequiredProperty("testWhileIdle")));
		dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getRequiredProperty("timeBetweenEvictionRunsMillis")));
		dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getRequiredProperty("minEvictableIdleTimeMillis")));
		dataSource.setRemoveAbandoned(Boolean.parseBoolean(env.getRequiredProperty("removeAbandoned")));
		dataSource.setRemoveAbandonedTimeout(Integer.parseInt(env.getRequiredProperty("removeAbandonedTimeout")));
		dataSource.setLogAbandoned(Boolean.parseBoolean(env.getRequiredProperty("logAbandoned")));
		return dataSource;
	}

	/**
	 * Initialize hibernate properties
	 * 
	 * @return Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.jdbc.batch_size", env.getRequiredProperty("hibernate.batch.size"));
//		properties.put("hibernate.current_session_context_class", env.getRequiredProperty("hibernate.current_session_context_class"));
		return properties;
	}

	/**
	 * Initialize SessionFactory
	 * 
	 * @return LocalSessionFactoryBean
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "info.sugengbin.springboot.model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	/**
	 * Initialize Transaction Manager
	 * 
	 * @param sessionFactory
	 * @return HibernateTransactionManager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
