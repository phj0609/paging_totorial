package me.hyun.config;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RootConfigTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void dataSoureTest() {
		assertNotNull(dataSource);
	}

}
