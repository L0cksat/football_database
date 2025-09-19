package modelo.dao;

import java.util.List;

import modelo.entities.Player;

public class PlayerDaoImplJpa extends AbsGenericoJpa implements PlayerDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> findAll() {
		jpql = "select p from Player p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Player findById(int playerCode) {
		return em.find(Player.class, playerCode);
	}

	@Override
	public int insertOne(Player player) {
		try {
			tx.begin();
				em.persist(player);
			tx.commit();
			filas = 1;
		}catch(Exception e) {
			System.out.println("An error has occurred creating the player.");
			filas = 0;
		}
		return filas;
	}

	@Override
	public int updateOne(Player player) {
		try {
			if(findById(player.getPlayerCode()) != null) {
				tx.begin();
					em.merge(player);
				tx.commit();
				filas = 1;
			}
		}catch(Exception e) {
			System.out.println("An error has occurred updating the player.");
			filas = 0;
		}
		return filas;
	}

	@Override
	public int deleteOne(int playerCode) {
		Player player = null;
		try {
			player = findById(playerCode);
			if(player != null) {
				tx.begin();
					em.remove(player);
				tx.commit();
				filas = 1;
			}
		}catch(Exception e) {
			System.out.println("An error has occurred deleting the player.");
			filas = 0;
		}
		return filas;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> findByTeam(int teamName) {
		jpql = "select p from Player p where p.teamId.teamId = ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, teamName);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> searchPlayer(String subcadena) {
		jpql = "select p from Player p where p.playerName like ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, "%" + subcadena + "%");
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> searchByCountry(String countryOrigin) {
		jpql = "select p from Player p where p.countryOrigin = ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, countryOrigin);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> searchByPosition(String position) {
		jpql = "select p from Player p where p.position = ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, position);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Player> searchByShirtNumber(String shirtNumber) {
		jpql = "select p from Player p where p.shirtNumber = ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, shirtNumber);
		return query.getResultList();
	}
	

}
