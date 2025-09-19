package modelo.dao;

import java.util.List;

import modelo.entities.Team;

public class TeamDaoImplJpa extends AbsGenericoJpa implements TeamDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findAll() {
		jpql = "select t from Team t";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Team findById(int teamId) {
		return em.find(Team.class, teamId);
	}

	@Override
	public int insertOne(Team team) {
		filas = 0;
		try {
				tx.begin();
					em.persist(team);
				tx.commit();
				filas = 1;
		}catch(Exception e) {
			System.out.println("Error al insertar el equipo.");
			filas = 0;
		}
		return filas;
	}

	@Override
	public int updateOne(Team team) {
		filas = 0;
		try {
			if(findById(team.getTeamId()) != null) {
				tx.begin();
					em.merge(team);
				tx.commit();
				filas = 1;
			}
		}catch (Exception e) {
			System.out.println("Error al modificar el equipo.");
			filas = 0;
		}
		return filas;
	}
	
	@Override
	public int deleteOne(int teamId) {
		Team team = null;
		try {
			team = findById(teamId);
			if(team != null) {
				tx.begin();
					em.remove(team);
				tx.commit();
				filas = 1;
			}else
				filas = -1;
		}catch (Exception e) {
			System.out.println("Error al eliminar el equipo.");
			filas = 0;
		}
		return filas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findByLeague(int leagueCode) {
		jpql = "Select t from Team t where t.leagueCode.leagueCode = ?1";
		query = em .createQuery(jpql);
		query.setParameter(1, leagueCode);
		return query.getResultList();
	}

	
}
