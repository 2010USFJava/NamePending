package com.revature.utility;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logit {

	public logit() {
		// TODO Auto-generated constructor stub
	}
	
 static Logger logger = LogManager.getLogger();
     
     public static void LogIt(String level, String message) throws SQLException{
    	 switch(level) {
 		case "debug":
 			logger.debug(message);
 			break;
 		case "warn":
 			logger.warn(message);
 			break;
 		case "error":
 			logger.error(message);
 			break;	
 		case "fatal":
 			logger.fatal(message);
 			break;
 		case "info":
 			logger.info(message);
 			break;
 		case "trace":
 			logger.trace(message);
 			break;
 		default:
 			System.err.println("utoh");
 		} 
    	 String sql = "insert into logs(log_level, log_message) values (?,?)";
    	 PreparedStatement ps =Stmnt.makePrStmnt(sql);
         ps.setString(1, level);
         ps.setString(2, message);
         ps.executeUpdate();
     }

}