package example.hibernate.one_to_many_unidirectional.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "CricketTeam_Master")
public class CricketTeam {
	@Id
	@Column(name = "team_id")
	private String teamId;
	@Column(name = "team_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_code")//This is the Foreign Key column from CricketPlayer_Master which refers to Primary Key of CricketTeam_Master
	private Set<CricketPlayer> players;
	public CricketTeam() {
		// TODO Auto-generated constructor stub
		players = new HashSet<CricketPlayer>();
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
		//It adds incoming CricketPlayer: playerRef into existing Set: players
		players.add(playerRef);
	}

}
