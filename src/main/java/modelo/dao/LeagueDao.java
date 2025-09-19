package modelo.dao;

import java.util.List;

import modelo.entities.League;

public interface LeagueDao {
	
	List<League> findAll();
	League findById(int leagueCode);
	int insertOne (League league);
	int updateOne (League league);
	int deleteOne (int leagueCode);

}
