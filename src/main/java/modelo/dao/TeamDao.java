package modelo.dao;

import java.util.List;

import modelo.entities.Team;

public interface TeamDao {
	
	List<Team> findAll();
	Team findById(int teamId);
	int insertOne(Team team);
	int updateOne(Team team);
	int deleteOne(int teamId);
	
	List<Team> findByLeague(int leagueCode);

}
