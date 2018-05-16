package problems.thirty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import processor.Problem;

public class ProblemThirtyFive extends Problem{
	private static String INFO_PATH = "problems/thirty/ThirtyFiveInfo.txt";
	@Override
	public String getProblemInfoPath() {
		return INFO_PATH;
	}

	@Override
	public void logSolution() {
		ArrayList<ArrayList<Integer>> base2List = new ArrayList<>();
		
		for(int digits = 1; digits < 19; digits++) {
			ArrayList<Integer> number = new ArrayList<>(digits);
			number.set(0, 1);
			number.set(number.size() - 1, 1);
			for(int i = 1; i < (digits - 1)/2; i++) {
				ArrayList<ArrayList<Integer>> permutationList = getPermutations(i);
				ArrayList<ArrayList<Integer>> base2Permutations = makeBase2Palindromes(number, permutationList);
				base2List.addAll(base2Permutations);
			}
		}
	}
	
	private ArrayList<ArrayList<Integer>> makeBase2Palindromes(ArrayList<Integer> number, ArrayList<ArrayList<Integer>> permutationList) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<ArrayList<Integer>> getPermutations(int n) {
		LinkedList<ArrayList<Integer>> stack = new LinkedList<>();
		ArrayList<ArrayList<Integer>> permutationList = new ArrayList<>();
		stack = new LinkedList<>();
		stack.push(new ArrayList<Integer>(n));
		while(!stack.isEmpty()) {
			ArrayList<Integer> list = stack.pop();
			for(int i = 0; i < list.size(); ){
				if(list.get(i) == null) {
					ArrayList<Integer> zeroList = new ArrayList<>(list);
					ArrayList<Integer> oneList = new ArrayList<>(list);
					zeroList.set(i, 0);
					oneList.set(i, 1);
					if(i == list.size() - 1) {
						permutationList.add(zeroList);
						permutationList.add(oneList);
					}else {
						stack.push(zeroList);
						stack.push(oneList);
					}
					break;
				}
			}
		}
		return permutationList;
	}

}
