package processor;

import util.ProblemPrinter;

public abstract class Problem {
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
