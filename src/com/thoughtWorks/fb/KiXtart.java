package com.thoughtWorks.fb;

import java.util.Scanner;

import com.thoughtWorks.objs.Game;

public class KiXtart {
	private int counter = 0;

	public static void main(String[] args) {
		System.out.println("Kix-tart");
		Scanner input = new Scanner(System.in);
		// startTheGame(input);
		testTheGame(input);
	}

	private static void startTheGame(Scanner input) {
		String[] country = input.next().split(" ");
		Game game = new Game(country[0], country[1]);
		String[] personCount = input.next().split(" ");
	}

	private static void testTheGame(Scanner input) {
		String str1 = "India Brazil";
		String str2 = "2 1";
		String str3[] = { "Ravi, India", "Rahul, Brazil" };
		String str5[] = { "Vijay, CNN news" };
		String str6[] = { "Goal: India", "game over" };
		String[] country = str1.split(" ");
		Game game = new Game(country[0], country[1]);
		String[] personCount = str2.split(" ");
		for (int i = 0; i < Integer.parseInt(personCount[0]); i++) {
			String s[] = str3[i].split(", ");
			if (s[1].equals(game.getTeam1().getName())) {
				game.getTeam1().setSupporter(s[0]);
			}else {
				game.getTeam2().setSupporter(s[0]);
			}

		}
		for (int i = 0; i < Integer.parseInt(personCount[1]); i++) {
			String s[] = str5[i].split(", ");
			game.setReporter(s[0], s[1]);
		}
		int i = 0;
		while (!str6[i].toLowerCase().equals("game over")) {
			game.updateScore(str6[i++]);
		}
		game.endTheGame();
		System.out.println(game);

	}
}
