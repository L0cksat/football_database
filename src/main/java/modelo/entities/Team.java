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
@Table(name="TEAMS")

public class Team implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="TEAM_ID")
	private int teamId;
	@Column(name="NAME_TEAM")
	private String teamName;
	@Column(name="COUNTRY")
	private String country;
	
	@ManyToOne
	@JoinColumn(name="DIVISION")
	private League leagueCode;

	public Team(int teamId, String teamName, String country, League leagueCode) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.country = country;
		this.leagueCode = leagueCode;
	}

	public Team() {
		super();
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public League getLeagueCode() {
		return leagueCode;
	}

	public void setLeagueCode(League leagueCode) {
		this.leagueCode = leagueCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return teamId == other.teamId;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", country=" + country + ", leagueCode="
				+ leagueCode + "]";
	}

	
	

}
