package testing.dao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.LeagueDao;
import modelo.dao.LeagueDaoImplJpa;
import modelo.dao.PlayerDao;
import modelo.dao.PlayerDaoImplJpa;
import modelo.dao.TeamDao;
import modelo.dao.TeamDaoImplJpa;
import modelo.entities.Player;
import modelo.entities.Team;

public class TestPlayerDaoJpa {
	private static LeagueDao ldao;
	private static TeamDao  tdao;
	private static PlayerDao pdao;
	static {
		ldao = new LeagueDaoImplJpa();
		tdao = new TeamDaoImplJpa();
		pdao = new PlayerDaoImplJpa();
	}

	public static void main(String[] args) {
		//findAll(); //WORKING
		//findOne(); //WORKING
		//insertOne(); //WORKING
		//updateOne(); //WORKING
		//deleteOne(); //WORKING
		//findPlayerByTeam(); //WORKING
		//findPlayerByName(); //WORKING
		//findPlayerByPosition(); //WORKING
		findPlayerByShirtNumber(); //WORKING

	}
	
	public static void findAll() {
		System.out.println("Here you have a complete list of all of the players: \n");
		for(Player ele : pdao.findAll()) {
			//System.out.println(ele);
			System.out.println("Player ID: " + ele.getPlayerCode() + " " + "Player Name: " + ele.getPlayerName() + " " + "Country: " + ele.getCountryOrigin() + " " 
			+ "Position: " + ele.getPosition() + " " + "Team: " + ele.getTeamId().getTeamName() + " " + "Shirt Number: " + ele.getShirtNumber());
		}
	}
	
	public static void findOne() {
		System.out.println("Please enter the player's ID code: ");
		Scanner leer = new Scanner(System.in);
		int codePlayer = leer.nextInt();
		Player player = pdao.findById(codePlayer);
		System.out.println("Here is the player you requested: " + player.getPlayerName());
		leer.close();
	}
	
	public static void insertOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the following information to create a player: \n");
		System.out.println("Please enter the player's ID Code: ");
		int codePlayer = leer.nextInt();
		leer.nextLine();
		System.out.println("Please enter the player's full name: \n");
		String playerName = leer.nextLine();
		System.out.println("Please enter the player's position: \n");
		String playerPosition = leer.nextLine();
		System.out.println("Please enter the player's country of origin: \n");
		String playerCountry = leer.nextLine();
		System.out.println("Please enter the player's shirt number: \n");
		String playerShirtNumber = leer.nextLine();
		System.out.println("Please enter the player's team's ID code: \n");
		int playerTeamCode = leer.nextInt();
		Team team = tdao.findById(playerTeamCode);
		
		if (team != null) {
			Player player1 = new Player(codePlayer, playerName, playerPosition, playerCountry, playerShirtNumber, team);
			System.out.println("We are processing the new player, I need to receive a 1, and I have recieved a: " + pdao.insertOne(player1));
		}else
			System.out.println("We encountered an error processing the new player.");
		leer.close();
	}
	
	public static void updateOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the ID code of the player you wish to update: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("Please enter the new information for each detail: \n");
		System.out.println("Please enter the new name: \n");
		String name = leer.nextLine();
		System.out.println("Please enter the new position: \n");
		String position = leer.nextLine();
		System.out.println("Please enter the new country of origin: \n");
		String country = leer.nextLine();
		System.out.println("Please enter the new shirt number: \n");
		String shirt = leer.nextLine();
		System.out.println("Please enter the new team ID: \n");
		int teamId = leer.nextInt();
		Team team = tdao.findById(teamId);
		
		if(team != null) {
			Player player = new Player(id, name, position, country, shirt, team);
			System.out.println("We are processing the modifcations, I should receive a 1 and I have received a: " + pdao.updateOne(player));
		}else
			System.out.println("We encountered an error processing the modifications.");
		leer.close();
	}
	
	public static void deleteOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the player ID code for the player you wish to delete: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("We are processing the deletion of the requested player, I should receive a 1, and I have received a: " + pdao.deleteOne(id));
		leer.close();
	}
	
	public static void findPlayerByTeam() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the team ID code to see its players: \n");
		int teamId = leer.nextInt();
		leer.nextLine();
		Team teamName = tdao.findById(teamId);
		List<Player> players = pdao.findByTeam(teamId);
		System.out.println("Here is the list of the players currently on the selected team: " + teamName.getTeamName());
		for(Player ele: players) {
			System.out.println("ID: " + ele.getPlayerCode() + ", Player name: " + ele.getPlayerName() 
			+ ", Position: " + ele.getPosition() + ", Country: " + ele.getCountryOrigin() + ", Shirt Number: " + ele.getShirtNumber());
		}
		leer.close();
	}
	
	public static void findPlayerByName() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the player's name, that you wish to search for: \n");
		String name = leer.nextLine();
		System.out.println("Here is a list of all the players that have been found: \n");
		for(Player ele: pdao.searchPlayer(name)) {
			System.out.println(ele.getPlayerName() + ", Team: " + ele.getTeamId().getTeamName());
		}
		leer.close();
	}
	
	public static void findPlayerByPosition() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the position you would like a list of. Only type GK, DF, MF, FW: \n");
		String position = leer.nextLine();
		System.out.println("This is the selected position: " + position);
		if(position.equals("GK") || position.equals("DF") || position.equals("MF") || position.equals("FW")) {
			System.out.println("Here is a list of all the players that play in the selected position: " + position);
			for (Player ele: pdao.searchByPosition(position)) {
				System.out.println(ele.getPlayerName() + ", Team: " + ele.getTeamId().getTeamName());
			}
		}else
			System.out.println("You haven't entered a valid position.");
		leer.close();
	}
	
	public static void findPlayerByShirtNumber() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the shirt number to see a list of players who wear that shirt number: \n");
		String number = leer.nextLine();
		System.out.println("Here is a list of player who wear the number " + number);
		for (Player ele: pdao.searchByShirtNumber(number)) {
			System.out.println(ele.getPlayerName() + ", Team: " + ele.getTeamId().getTeamName());
		}
		leer.close();
	}
	

}
