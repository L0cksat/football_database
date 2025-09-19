package modelo.dao;

import java.util.List;

import modelo.entities.Player;

public interface PlayerDao {
	
	List<Player> findAll();
	Player findById(int playerCode);
	int insertOne(Player player);
	int updateOne(Player player);
	int deleteOne(int playerCode);
	
	List<Player> findByTeam(int teamName);
	List<Player> searchPlayer(String subcadena);
	List<Player> searchByCountry (String countryOrigin);
	List<Player> searchByPosition (String position);
	List<Player> searchByShirtNumber (String shirtNumber);

}
