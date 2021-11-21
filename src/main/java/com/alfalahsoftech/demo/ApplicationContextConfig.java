/*
 * package com.alfalahsoftech.demo;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * import org.springframework.web.servlet.view.InternalResourceViewResolver;
 * 
 * @Configuration //@ComponentScan("com.fyt.fyt")
 * 
 * @EnableTransactionManagement public class ApplicationContextConfig {
 * 
 * 
 * @Bean public InternalResourceViewResolver getViewResolver() {
 * InternalResourceViewResolver internalResourceViewResolver = new
 * InternalResourceViewResolver();
 * internalResourceViewResolver.setPrefix("/WEB-INF/views/");
 * internalResourceViewResolver.setSuffix(".jsp"); return
 * internalResourceViewResolver; }
 * 
 * @Bean public DataSource getDataSource() { BasicDataSource dataSource = new
 * BasicDataSource(); dataSource.setDriverClassName("com.mysql.jdbc.Driver");
 * dataSource.setUrl("jdbc:mysql://localhost:3306/fyt");
 * dataSource.setUsername("root"); dataSource.setPassword(""); return
 * dataSource; }
 * 
 * @Bean public LocalSessionFactoryBean getSessionFactory() {
 * 
 * LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 * factoryBean.setDataSource(getDataSource());
 * factoryBean.setHibernateProperties(getHibernateProperties());
 * factoryBean.setAnnotatedClasses(User.class); return factoryBean;
 * 
 * }
 * 
 * private Properties getHibernateProperties() { Properties properties = new
 * Properties(); properties.put("hibernate.show_sql", "true");
 * properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 * return properties; }
 * 
 * @Bean public HibernateTransactionManager getTransactionManager() {
 * HibernateTransactionManager transactionManager = new
 * HibernateTransactionManager();
 * transactionManager.setSessionFactory(getSessionFactory().getObject()); return
 * transactionManager; }
 * 
 * @Bean public UserDao userDao() { return new UserDaoImpl(); } }
 */