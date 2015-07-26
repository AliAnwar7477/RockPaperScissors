package solutioncode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockPaperScissors {
	
	/**
	 * An implementation of Rock-Paper-Scissors.
	 */
	
	//A List of previous moves for the CPU to analyze when determining its moves
	List<Integer> previousMoves;
	
	//A String array of each possible move
	String[] moves = {"ROCK", "PAPER", "SCISSORS"};
	
	
	int recentMoveSetSize = 3;
	
	//The round number
	int round;
	
	//Score counters
	int humanScore;
	int computerScore;
	int ties;
	
	//Constants representing each possible move
	static final int ROCK = 0;
	static final int PAPER = 1;
	static final int SCISSORS = 2;
	
	//An enum representing each possible outcome of a round
	public enum Outcome {WIN, LOSS, TIE};
	
	RockPaperScissors(){
		
	}
	
	public void executeRound(){
		
		//Get human move
	}
	
	public void computerMove(){
		
		//Insert algorithm for getting computer move
		historyAnalysis();
	}
	
	public Outcome determineWinner(int playerMove, int computerMove){
		
		if(playerMove == ROCK && computerMove == SCISSORS)
			return Outcome.WIN;
		
		else if(playerMove == PAPER && computerMove == ROCK)
			return Outcome.WIN;
		
		else if(playerMove == SCISSORS && computerMove == PAPER)
			return Outcome.WIN;
		
		else if(playerMove == ROCK && computerMove == PAPER)
			return Outcome.LOSS;
		
		else if(playerMove == PAPER && computerMove == SCISSORS)
			return Outcome.LOSS;
		
		else if(playerMove == SCISSORS && computerMove == ROCK)
			return Outcome.LOSS;
		
		else if(playerMove == computerMove)
			return Outcome.TIE;
		
		return null;
	}
	
	private class HistoryAnalysis implements RPSAlgorithm {
		
	public int calculateMove(){
		
		if(previousMoves.size() > recentMoveSetSize){
			
			int computerMove = -1;

			List<Integer> recentMoves = new ArrayList<Integer>();
			List<Integer> predictedMoves = new ArrayList<Integer>();
			
			for(int i = previousMoves.size() - recentMoveSetSize; i < previousMoves.size(); i++){
				recentMoves.add(previousMoves.get(i));
			}
			
			for(int i = 0; i < previousMoves.size() - recentMoveSetSize; i++){
				
				List<Integer> subList = previousMoves.subList(i, i + recentMoveSetSize);
				//System.out.println("Sublist " + i + " : " + subList);
				if(areArrayListsEqual(subList, recentMoves)){
					System.out.println("Matching sublist : " + subList);
					if(previousMoves.size() > i + recentMoveSetSize + 1){
						System.out.println("Predicted move: " + previousMoves.get(i + recentMoveSetSize));
						predictedMoves.add(previousMoves.get(i + recentMoveSetSize));
					}
				}
			}
			System.out.println("Previous " + previousMoves);
			System.out.println("Recent " + recentMoves);
			System.out.println("Predicted " + predictedMoves);
			
			Random generator = new Random();
			if(predictedMoves.size() > 0)
				computerMove = getCounterMove(predictedMoves.get(generator.nextInt(predictedMoves.size())));
			else{
				computerMove = generator.nextInt(3);
			}
			
			return computerMove;
		}
		else{
			Random generator = new Random();
			return generator.nextInt(3);
		}
	}
	
	private boolean areArrayListsEqual(List<Integer> listOne, List<Integer> listTwo){
		
		boolean areArrayListsEqual = true;
		
		if(listOne.size() != listTwo.size())
			return false;
		
		for(int i = 0; i < listOne.size(); i++){
			if(listOne.get(i) != listTwo.get(i))
				areArrayListsEqual = false;
		}
		
		return areArrayListsEqual;
	}
	
	private int getCounterMove(int move){
		
		int counterMove = -1;
		
		switch(move){
		
		case ROCK: 
			counterMove = PAPER;
			break;
		
		case PAPER: 
			counterMove = SCISSORS;
		    break;
		
		case SCISSORS: 
			counterMove = ROCK;
			break;
		}
		
		return counterMove;
	}
	
	}
	
	public static 
	
	/**
	 * Rock-Paper-Scissors algorithms for use by the CPU.
	 */

}
