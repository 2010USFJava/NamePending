package com.revature.utility;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class LogItTest {

	
	@Test
	public void testLogIt() throws SQLException, IOException {
		logit.LogIt("info", "Testing Logger");
	}

	
}
