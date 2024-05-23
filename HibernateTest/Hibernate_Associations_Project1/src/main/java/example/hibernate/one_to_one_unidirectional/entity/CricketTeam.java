package example.hibernate.one_to_one_unidirectional.entity;

import java.util.Set;

public class CricketTeam {
	private String teamId;
	private String name;
	private Set<CricketPlayer> players;
	public CricketTeam() {
		// TODO Auto-generated constructor stub
	}
	public CricketTeam(String teamId, String name, Set<CricketPlayer> players) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.players = players;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<CricketPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(Set<CricketPlayer> players) {
		this.players = players;
	}
	public void addPlayer(CricketPlayer playerRef) {
		//This method is used for convenience: Allows to add one player at a time.
		players.add(playerRef);
	}

}
