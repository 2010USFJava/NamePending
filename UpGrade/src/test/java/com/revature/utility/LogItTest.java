package com.revature.utility;

import java.sql.SQLException;

import org.junit.Test;

public class LogItTest {

	
	@Test
	public void testLogIt() throws SQLException {
		logit.LogIt("info", "Testing Logger");
	}

	
}
