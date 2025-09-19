package com.window;

import java.util.List;

import modelo.dao.LeagueDao;
import modelo.dao.LeagueDaoImplJpa;
import modelo.dao.PlayerDao;
import modelo.dao.PlayerDaoImplJpa;
import modelo.dao.TeamDao;
import modelo.dao.TeamDaoImplJpa;
import modelo.entities.League;
import modelo.entities.Team;

public class DbManagement {

	private static LeagueDao ldao;
	private static PlayerDao pdao;
	private static TeamDao tdao;
	
	public DbManagement() {
		ldao = new LeagueDaoImplJpa();
		pdao = new PlayerDaoImplJpa();
		tdao = new TeamDaoImplJpa();
	}
	
	//Main menu methods
	public int leagueMenu() {
		return 0;
	}
	
	public int teamMenu() {
		return 0;
	}
	
	public int playerMenu() {
		return 0;
	}
	
	// League menu methods
	public List<League> getAllLeagues(){
		return ldao.findAll();
	}
	
	public League leagueFindById(int codeLeague) {
		return ldao.findById(codeLeague);
	}
	
	public int createLeague (int code, String name, String country, int tier) {
		League league = new League(code, name, country, tier);
		return ldao.insertOne(league);
	}
	
	public int editLeague (int id, String name, String country, int tier) {
		League leagueId = ldao.findById(id);
		
		if (leagueId != null) {
			League league = new League(id, name, country, tier);
			return ldao.updateOne(league);
		}else {
			return 0;
		}
		
	}
	
	public int deleteLeague(int id) {
		League leagueId = ldao.findById(id);

        if (leagueId != null) {
            return ldao.deleteOne(id);
        }else{
            return 0;
        }
	}

    // Team menu methods
    public List<Team> getAllTeams(){
        return tdao.findAll();
    }

    public Team teamFindById(int codeTeam) {
        return tdao.findById(codeTeam);
    }

    public int createTeam(int id, String name, String country, League league) {
        Team teamId = tdao.findById(id);
        if (teamId != null) {
            Team team = new Team(id, name, country, league);
            return tdao.insertOne(team);
        } else {
            return 0;
        }
    }

    public int editTeam (int id, String name, String country, League league) {
        Team teamId = tdao.findById(id);
        if (teamId != null) {
            Team team = new Team(id, name, country, league);
            return tdao.updateOne(team);
        }else{
            return 0;
        }

    }
}
