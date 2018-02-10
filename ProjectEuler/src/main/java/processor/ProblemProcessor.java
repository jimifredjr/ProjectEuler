package processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import problems.ten.ProblemOne;
import problems.ten.ProblemTwo;

/**
 * 
 * @author Jimifredjr
 *
 */
public class ProblemProcessor {
	private static List<Problem> problemList = new ArrayList<>(Arrays.asList(
			new ProblemOne(),
			new ProblemTwo()
		));
	
	public static void main(String[] args) {
		for(Problem problem: problemList){
			problem.logProblem();
		}
	}
}
