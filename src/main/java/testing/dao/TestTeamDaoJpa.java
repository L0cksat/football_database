package testing.dao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.LeagueDao;
import modelo.dao.LeagueDaoImplJpa;
import modelo.dao.TeamDao;
import modelo.dao.TeamDaoImplJpa;
import modelo.entities.League;
import modelo.entities.Team;

public class TestTeamDaoJpa {
	private static TeamDao tdao;
	private static LeagueDao ldao;
	static {
		tdao = new TeamDaoImplJpa();
		ldao = new LeagueDaoImplJpa();
	}
	public static void main(String[] args) {
		
		findAll(); //WORKING
		//findOne(); //WORKING
		//findByLeague(); //WORKING
		//insertOne(); //WORKING
		//updateOne(); //WORKING
		//deleteOne(); //WORKING
		
	}
	
	public static void findAll() {
		System.out.println("Here you have a complete list of all of the teams:\n");
		for(Team ele: tdao.findAll()) {
			//System.out.println(ele);
			System.out.println(ele.getTeamName() + ", " + ele.getCountry() + ", " + ele.getLeagueCode().getLeagueName() + ", " 
			+ ele.getLeagueCode().getCountry() + ", Tier: " + ele.getLeagueCode().getTier());
		}
	}
	
	public static void findOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the team id code to search:\n");
		int codeTeam = leer.nextInt();
		Team team = tdao.findById(codeTeam);
		System.out.println("The search has returned the following team: " + team.getTeamName());
		leer.close();
	}
	
	public static void findByLeague() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the league id code to see a list of its teams: \n");
		int codeLeagueTeams = leer.nextInt();
		League leagueName = ldao.findById(codeLeagueTeams);
		List<Team> teams = tdao.findByLeague(codeLeagueTeams);
		System.out.println("The search has returned the following teams from the requested league: " +  leagueName.getLeagueName());
		for (Team ele: teams) {
			System.out.println(ele.getTeamId() + ": " + ele.getTeamName() + ", " + ele.getCountry());
		}
		leer.close();
	}
	
	public static void insertOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the details of the team you wish to insert.\n");
		System.out.println("Please enter the ID code.\n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("Please enter the team name.\n");
		String name = leer.nextLine();
		System.out.println("Please enter the team's country.\n");
		String country = leer.nextLine();
		System.out.println("Please enter the team's league code.\n");
		int leagueId = leer.nextInt();
		leer.nextLine();
		League league = ldao.findById(leagueId);
		
		if(league != null) {
			Team team1 = new Team(id, name, country, league);
			System.out.println("We are processing the insertion of the new team, I am hoping for a 1, and I have recieved a: " + tdao.insertOne(team1));
		}else
			System.out.println("We have not been able to process the insertion of the new team.");
		leer.close();
		
	}
	
	public static void updateOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the ID code of the team you wish to modify: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("Please enter the details you would like to modify.\n");
		System.out.println("Please enter the new team name.\n");
		String name = leer.nextLine();
		System.out.println("Please enter the new country.\n");
		String country = leer.nextLine();
		System.out.println("Please enter the new league Id code.\n");
		int leagueId = leer.nextInt();
		League league = ldao.findById(leagueId);
		
		if(league != null) {
			Team team = new Team(id, name, country, league);
			System.out.println("We are processing the modification of the details of the requested team, I am hoping for a 1, and I have received a: " + tdao.updateOne(team));
		}else
			System.out.println("We have not been able to process the modification of the team.");
		leer.close();
	}
	
	public static void deleteOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the ID code of the team you wish to delete: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("We are processing the deletion of the requested team, I am hoping for a 1, and I have received a: " + tdao.deleteOne(id));
		leer.close();
	}

}
