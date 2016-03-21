package com.thoughtWorks.objs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {
	private String name;
	private int score;
	private Map<Integer, Date> scoreTable;
	private List<Supporter> supporters;

	public Team(String name) {
		this.name = name;
		score = 0;
		supporters = new ArrayList<Supporter>();
		scoreTable = new HashMap<Integer, Date>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Map<Integer, Date> getScoreTable() {
		return scoreTable;
	}

	public void setScoreTable(Map<Integer, Date> scoreTable) {
		this.scoreTable = scoreTable;
	}

	public List<Supporter> getSupporters() {
		return supporters;
	}

	public void setSupporters(List<Supporter> supporters) {
		this.supporters = supporters;
	}

	public void setSupporter(String string) {
		supporters.add(new Supporter(string));
	}

	public void updateScore() {
		scoreTable.put(++score, new Date());
		expressJoy();
	}

	public void expressJoy() {
		for (Supporter s : supporters) {
			System.out.println(s.getName() + " says: Hurrah!");
		}

	}

	public void expressSorrow() {
		for (Supporter s : supporters) {
			System.out.println(s.getName() + " says: Alas!");
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [name=");
		builder.append(name);
		builder.append(", score=");
		builder.append(score);
		builder.append(", scoreTable=");
		builder.append(scoreTable);
		builder.append(", supporters=");
		builder.append(supporters);
		builder.append("]");
		return builder.toString();
	}

}
