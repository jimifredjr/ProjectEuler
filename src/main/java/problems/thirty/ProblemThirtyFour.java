package problems.thirty;

import java.util.HashMap;
import java.util.Map;

import processor.Problem;

public class ProblemThirtyFour extends Problem{

	private static String INFO_PATH = "problems/thirty/ThirtyFourInfo.txt";
	private Map<Integer, Integer> factorialMap = new HashMap<>();
	@Override
	public String getProblemInfoPath() {
		return INFO_PATH;
	}

	@Override
	public void logSolution() {
		for(int i = 0; i < 10; i++) {
			factorialMap.put(i, factorial(i));
		}
		
		int total = 0;
		int x = 10;
		while(x < 9*Math.pow(10, 7)) {
			int sum = getDigitFactorialSum(x);
			if(sum == x) {
				total +=x;
			}
			x++;
		}
		logContent("The total is: " + total);
	}

	private int getDigitFactorialSum(int x) {
		int total = 0;
		String number = x+"";
		for(int i = 0; i < number.length(); i++) {
			total += factorialMap.get(Integer.parseInt(number.substring(i, i+1)));
		}
		
		return total;
	}
	
	public static int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

}
