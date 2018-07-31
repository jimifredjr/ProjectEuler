package processor;

import java.io.Serializable;

import util.log.ProblemPrinter;

public abstract class Problem implements Serializable{
	public abstract String getProblemInfoPath();
	public abstract void logSolution();
	
	
	public void logProblem(){
		ProblemPrinter.logContent("Processing Problem: "+this.getClass().getSimpleName());
		ProblemPrinter.logFileContent(getProblemInfoPath());
		logSolution();
	}
	
	public void logContent(String content, String ... args){
		ProblemPrinter.logContent(content, args);
	}
}
