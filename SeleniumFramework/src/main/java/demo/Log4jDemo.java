package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger= LogManager.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n Hello World....\n");
		logger.info("Information");
		logger.error("Error");
		logger.warn("warning");
		logger.fatal("fatal");

	}

}
