package util.log;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProblemPrinter {
	private static Logger logger = LoggerFactory.getLogger(ProblemPrinter.class);
	private static String RESOURCE_PATH = "src/main/resources/";
	/**
	 * Print
	 * @param resourcePath
	 */
	public static void logFileContent(String resourcePath){
		logContent("Resource Path", resourcePath);
		File file = new File(RESOURCE_PATH+resourcePath);
		try(Scanner scan = new Scanner(file)){
			while(scan.hasNextLine()){
				logContent(scan.nextLine());
			}
		} catch (IOException e) {
			logger.error("Exception opening stream to resource", e);
		}
	}
	
	public static void logContent(String content, String ... args){
		logger.info(content);
		for(String arg: args){
			logger.info("Arg: " + arg);
		}
	}
	
	
	
}
