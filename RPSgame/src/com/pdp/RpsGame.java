package com.pdp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RpsGame {
	
	private final String RESULT1 = "Player wins";
	private final String RESULT2 = "CPU wins";
	private final String ROCK = "Rock";
	private final String PAPER = "Paper";
	private final String SCISSOR = "Scissor";
	private final int MAX = 3;
	private final int MIN = 1;
	private Map<Integer, String> choicesMap = new HashMap<Integer, String>(){{
		put(1, "Rock");
		put(2, "Paper");
		put(3, "Scissor");
	}};
	
	private String startGame() {
		String result = "";
		int cpuChoiceInt, playerChoiceInt;
		String cpuChoice = "", playerChoice = "";
		int cpuWins = 0, playerWins = 0;
		
		while(!(cpuWins== 3 || playerWins == 3)) {
			System.out.println("Please make your choice:");
			System.out.print("1. Rock\n2. Paper\n3. Scissor\n");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
				case 1: playerChoice = choicesMap.get(1);
						break;
				case 2: playerChoice = choicesMap.get(2);
						break;
				case 3: playerChoice = choicesMap.get(3);
						break;
				default: System.out.println("Please make a valid choice...");
			}
			System.out.println("Player chooses: "+ playerChoice);
			cpuChoiceInt = new Random().nextInt((MAX - MIN) + 1) + MIN;
			cpuChoice = choicesMap.get(cpuChoiceInt);
			System.out.println("CPU chooses: "+ cpuChoice);
			
			if(playerChoice.equals(ROCK)) {
				if(cpuChoice.equals(ROCK)) {
					System.out.println("Match drawn...");
				}
				else if(cpuChoice.equals(SCISSOR)) {
					System.out.println("Player wins the match");
					playerWins++;
				}
				else if(cpuChoice.equals(PAPER)){
					System.out.println("CPU wins the match");
					cpuWins++;
				}
				System.out.println("Results:\nPlayer: "+playerWins+"\tCPU: "+cpuWins);
			}
			
			if(playerChoice.equals(PAPER)) {
				if(cpuChoice.equals(PAPER)) {
					System.out.println("Match drawn...");
				}
				else if(cpuChoice.equals(ROCK)) {
					System.out.println("Player wins the match");
					playerWins++;
				}
				else if(cpuChoice.equals(SCISSOR)){
					System.out.println("CPU wins the match");
					cpuWins++;
				}
				System.out.println("Results:\nPlayer: "+playerWins+"\tCPU: "+cpuWins);
			}
			
			if(playerChoice.equals(SCISSOR)) {
				if(cpuChoice.equals(SCISSOR)) {
					System.out.println("Match drawn...");
				}
				else if(cpuChoice.equals(PAPER)) {
					System.out.println("Player wins the match");
					playerWins++;
				}
				else if(cpuChoice.equals(ROCK)){
					System.out.println("CPU wins the match");
					cpuWins++;
				}
				System.out.println("Results:\nPlayer: "+playerWins+"\tCPU: "+cpuWins);
			}
		}
		if(playerWins == 3) {
			result = RESULT1;
		}else {
			result = RESULT2;
		}
		
		return result;
	}
	
	private int temp() {
		int s = new Random().nextInt(3);
		int randomNum, max=3, min=1;
		Random rand = new Random();
		randomNum = rand.nextInt((max - min) + 1) + min;
		System.out.println(randomNum);
		return randomNum;
	}

	public static void main(String[] args) {
		RpsGame game = new RpsGame();
		game.startGame();

	}

}
