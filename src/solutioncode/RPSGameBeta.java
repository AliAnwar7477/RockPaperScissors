package solutioncode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RPSGameBeta {
	
	List<Integer> previousMoves;
	String[] moves = {"ROCK", "PAPER", "SCISSORS"};
	int recentMoveSetSize = 3;
	int round;
	
	int humanScore;
	int computerScore;
	int ties;
	
	final int ROCK = 0;
	final int PAPER = 1;
	final int SCISSORS = 2;
	
	final int HUMAN_WON = 4;
	final int COMPUTER_WON = 5;
	final int TIE = 6;
	
	public static void main(String[] args){
		RPSGameBeta rockPaperScissors = new RPSGameBeta();
		
		rockPaperScissors.startGame();
	}
	
	public RPSGameBeta(){
		
		previousMoves = new ArrayList<Integer>();
		round = 1;
		
		humanScore = 0;
		computerScore = 0;
		ties = 0;
			
		System.out.println("You are playing Rock-Paper-Scissors.\nEnter \"R\", \"P\" or \"S\" to make your move.\nEnter \"Q\" to quit.");
	}
	
	public void executeRound(){
		
		Scanner reader = new Scanner(System.in);
		String humanResponse = "";
		
		int humanMove = -1;
		int computerMove = -1;
	
		System.out.println("\nRound " + round + ". Rock, paper or scissors?");
		
		humanResponse = reader.nextLine();		
		humanResponse = humanResponse.toLowerCase();
		
		if(humanResponse.equals("q"))
			System.exit(0);
		
		while(!(humanResponse.equals("r") || humanResponse.equals("p") || humanResponse.equals("s"))){
			System.out.println(humanResponse);
			System.out.println("Invalid move. Rock, paper, or scissors?");
			humanResponse = reader.nextLine();		
			humanResponse = humanResponse.toLowerCase();
		}
		
		switch(humanResponse){
		
		case "r": 
			humanMove = ROCK;
			break;
		
		case "p": 
			humanMove = PAPER;
		    break;
		
		case "s": 
			humanMove = SCISSORS;
			break;
		}
		
		System.out.println("You play " + moves[humanMove] + ".");
		
		computerMove = calculateMove();
		System.out.println("The computer plays " + moves[computerMove] + ".");
		
		previousMoves.add(humanMove);
		
		if(determineRoundWinner(humanMove, computerMove) == HUMAN_WON){
			System.out.println(moves[humanMove] + " beats " + moves[computerMove] + ". You win.");
			humanScore++;
		}
		else if(determineRoundWinner(humanMove, computerMove) == COMPUTER_WON){
			System.out.println(moves[computerMove] + " beats " + moves[humanMove] + ". The computer wins.");
			computerScore++;
		}
		else if(determineRoundWinner(humanMove, computerMove) == TIE){
			System.out.println("Both you and the computer played " + moves[humanMove] + ". It's a tie.");
			ties++;
		}
		
		round++;
		System.out.println("\nYour Score: " + humanScore + "   Computer Score: " + computerScore + "   Ties: " + ties);
		System.out.println("___________________________________________________");
	}
	
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
	
	public int determineRoundWinner(int humanMove, int computerMove){
		
		if(humanMove == ROCK && computerMove == SCISSORS)
			return HUMAN_WON;
		else if(humanMove == PAPER && computerMove == ROCK)
			return HUMAN_WON;
		else if(humanMove == SCISSORS && computerMove == PAPER)
			return HUMAN_WON;
		else if(humanMove == ROCK && computerMove == PAPER)
			return COMPUTER_WON;
		else if(humanMove == PAPER && computerMove == SCISSORS)
			return COMPUTER_WON;
		else if(humanMove == SCISSORS && computerMove == ROCK)
			return COMPUTER_WON;
		else if(humanMove == computerMove)
			return TIE;
		
		return -1;
	}
	
	public int startGame(){
		
		while(true){
			executeRound();
		}
	}
	
	

}
