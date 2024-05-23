package example.hibernate.one_to_one_unidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CricketPlayer_Master")
public class CricketPlayer {
	@Id
	@Column(name = "player_id")
	private String playerId;
	@Column(name = "player_name")
	private String name;
	@Column(name = "player_age")
	private int age;
	@Column(name = "player_batting_avg")
	private float battingAverage;
	public CricketPlayer() {
		// TODO Auto-generated constructor stub
	}
	public CricketPlayer(String playerId, String name, int age, float battingAverage) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.age = age;
		this.battingAverage = battingAverage;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(float battingAverage) {
		this.battingAverage = battingAverage;
	}
	@Override
	public String toString() {
		return "CricketPlayer [playerId=" + playerId + ", name=" + name + ", age=" + age + ", battingAverage="
				+ battingAverage + "]";
	}

}
