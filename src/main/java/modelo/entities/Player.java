package modelo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="PLAYERS")

public class Player implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PLAYER_ID")
	private int playerCode;
	@Column(name="NAME_PLAYER")
	private String playerName;
	@Column(name="POSITION")
	private String position;
	@Column(name="COUNTRY_ORI")
	private String countryOrigin;
	@Column(name="SHIRT_NUM")
	private String shirtNumber;
	
	@ManyToOne
	@JoinColumn(name="TEAM_NAME")
	private Team teamId;

	public Player(int playerCode, String playerName, String position, String countryOrigin, String shirtNumber,
			Team teamId) {
		super();
		this.playerCode = playerCode;
		this.playerName = playerName;
		this.position = position;
		this.countryOrigin = countryOrigin;
		this.shirtNumber = shirtNumber;
		this.teamId = teamId;
	}

	public Player() {
		super();
	}

	public int getPlayerCode() {
		return playerCode;
	}

	public void setPlayerCode(int playerCode) {
		this.playerCode = playerCode;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getShirtNumber() {
		return shirtNumber;
	}

	public void setShirtNumber(String shirtNumber) {
		this.shirtNumber = shirtNumber;
	}

	public Team getTeamId() {
		return teamId;
	}

	public void setTeamId(Team teamId) {
		this.teamId = teamId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return playerCode == other.playerCode;
	}

	@Override
	public String toString() {
		return "Player [playerCode=" + playerCode + ", playerName=" + playerName + ", position=" + position
				+ ", countryOrigin=" + countryOrigin + ", shirtNumber=" + shirtNumber + ", teamId=" + teamId + "]";
	}
	
	
	

}
