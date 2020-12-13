package com.revature.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logit {
	static Logger log = LogManager.getLogger();
	public static ConnFactory cf = ConnFactory.getInstance();

	public static void LogIt(String level, String message) throws IOException, SQLException{
		Connection conn = cf.getConnection();
		switch (level) {
		case "debug":
			log.debug(message);
			break;
		case "warn":
			log.warn(message);
			break;
		case "error":
			log.error(message);
			break;
		case "fatal":
			log.fatal(message);
			break;
		case "info":
			log.info(message);
			break;
		case "trace":
			log.trace(message);
			break;
		default:
			System.err.println("utoh");
		}
		String sql = "insert into logs(log_level, log_message) values (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, level);
		ps.setString(2, message);
		ps.executeUpdate();
		
	}

}