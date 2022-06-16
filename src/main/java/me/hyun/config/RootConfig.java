package me.hyun.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import me.hyun.service.MemberService;

@Configuration
@MapperScan("me.hyun.mapper")
@ComponentScan("me.hyun")
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost/member");
		config.setUsername("root");
		config.setPassword("1234");
		return new HikariDataSource(config);
	}
	
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/message/message","classpath:/message/errors"); // /message/message.properties
		source.setDefaultEncoding("utf-8");
		return source;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
}