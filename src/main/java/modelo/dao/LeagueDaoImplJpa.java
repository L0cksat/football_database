package modelo.dao;

import java.util.List;

import modelo.entities.League;

public class LeagueDaoImplJpa extends AbsGenericoJpa implements LeagueDao{

	public LeagueDaoImplJpa() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<League> findAll() {
		jpql = "select l from League l";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public League findById(int leagueCode) {
		return em.find(League.class, leagueCode);
	}

	@Override
	public int insertOne(League league) {
		try {
			tx.begin();
				em.persist(league);
			tx.commit();
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int updateOne(League league) {
		try {
			if(findById(league.getLeagueCode()) != null) {
			tx.begin();
				em.merge(league);
			tx.commit();
			filas= 1;
			}	
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int deleteOne(int leagueCode) {
		League league = null;
		try {
			league = findById(leagueCode);
			if(league != null) {
				tx.begin();
					em.remove(league);
				tx.commit();
				filas = 1;
			}else
				filas = -1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}
	

}
