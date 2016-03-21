package com.thoughtWorks.objs;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Team team1;
	private Team team2;
	private List<Reporter> reporters;

	public Game(String countryName1, String countryName2) {
		team1 = new Team(countryName1);
		team2 = new Team(countryName2);
		reporters = new ArrayList<Reporter>();
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public List<Reporter> getReporters() {
		return reporters;
	}

	public void setReporters(List<Reporter> reporters) {
		this.reporters = reporters;
	}

	public void setReporter(String name, String channelName) {
		reporters.add(new Reporter(name, channelName));

	}

	public void updateScore(String string) {
		String s[] = string.split(": ");
		if (s[1].equals(team1.getName())) {
			team1.updateScore();
			team2.expressSorrow();
		} else if (s[2].equals(team2.getName())) {
			team2.updateScore();
			team1.expressSorrow();
		}

	}

	public void endTheGame() {
		if (team1.getScore() > team2.getScore()) {
			List<Supporter> suppo = team1.getSupporters();
			for (int i = 0; i < suppo.size(); i++) {
				System.out.println((suppo.get(i)).getName() + " say Yes! " + team1.getName() + " won.");
			}
			List<Supporter> oppo = team2.getSupporters();
			for (int i = 0; i < oppo.size(); i++) {
				System.out.println((oppo.get(i)).getName() + " say Alas! " + team2.getName() + " lost.");
			}
			getReport(team1, team2);
		} else {
			List<Supporter> suppo = team2.getSupporters();
			for (int i = 0; i < suppo.size(); i++) {
				System.out.println((suppo.get(i)).getName() + " say Yes! " + team2.getName() + " won.");
			}
			List<Supporter> oppo = team1.getSupporters();
			for (int i = 0; i < oppo.size(); i++) {
				System.out.println((oppo.get(i)).getName() + " say Alas! " + team1.getName() + " lost.");
			}
			getReport(team2, team1);
		}
	}

	private void getReport(Team winner, Team loser) {
		for (Reporter re : reporters) {
			System.out.println(re.getName() + " reports: " + winner.getName() + " has won the game against "
					+ loser.getName() + " by " + winner.getScore() + "-" + loser.getScore() + ". Brought to you by "
					+ re.getChannelName() + ".");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [team1=");
		builder.append(team1);
		builder.append(", team2=");
		builder.append(team2);
		builder.append(", reporters=");
		builder.append(reporters);
		builder.append("]");
		return builder.toString();
	}

}
