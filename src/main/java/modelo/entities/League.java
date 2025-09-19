package modelo.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name="league")

public class League implements Serializable{
	private static final long serialVersionUID = 8294807375303846232L;
	@Id
	@Column(name="LEAGUE_ID")
	protected int leagueCode;
	@Column(name="NAME_LEAGUE")
	protected String leagueName;
	@Column(name="COUNTRY")
	protected String country;
	@Column(name="TIER")
	protected int tier;
	
	public League(int leagueCode, String leagueName, String country, int tier) {
		super();
		this.leagueCode = leagueCode;
		this.leagueName = leagueName;
		this.country = country;
		this.tier = tier;
	}

	public League() {
		super();
	}

	public int getLeagueCode() {
		return leagueCode;
	}

	public void setLeagueCode(int leagueCode) {
		this.leagueCode = leagueCode;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "League [leagueCode=" + leagueCode + ", leagueName=" + leagueName + ", country=" + country + ", tier="
				+ tier + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(leagueCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		League other = (League) obj;
		return leagueCode == other.leagueCode;
	}
	
	
	

}
