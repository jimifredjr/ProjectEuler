package problems.ten;

import processor.Problem;

public class ProblemOne extends Problem{
	private static String INFO_PATH = "problems/ten/OneInfo.txt";
	
	@Override
	public String getProblemInfoPath() {
		return INFO_PATH;
	}
	@Override
	public void logSolution() {
		int sum = 0;
		for(int i = 1; i < 1000; i++){
			if(i%3==0 || i%5==0) sum+=i;
		}
		logContent("Answer: " + sum);
	}
	
	
	
}
