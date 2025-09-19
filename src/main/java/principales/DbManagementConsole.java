package principales;

import java.util.List;
import java.util.Scanner;

import modelo.dao.LeagueDao;
import modelo.dao.LeagueDaoImplJpa;
import modelo.dao.PlayerDao;
import modelo.dao.PlayerDaoImplJpa;
import modelo.dao.TeamDao;
import modelo.dao.TeamDaoImplJpa;
import modelo.entities.League;
import modelo.entities.Player;
import modelo.entities.Team;

public class DbManagementConsole {
	private static LeagueDao ldao;
	private static PlayerDao pdao;
	private static TeamDao tdao;
	private static Scanner leer;
	
	static {
		ldao = new LeagueDaoImplJpa();
		pdao = new PlayerDaoImplJpa();
		tdao = new TeamDaoImplJpa();
		leer = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		int option;
		
		do {
			option = displayMenu();
			switch(option) {
			case 1:
				leagueMenu();
				break;
			case 2:
				teamMenu();
				break;
			case 3:
				playerMenu();
				break;
			}
			
		}while (option !=4);
		System.out.println("Program exited.");
	}
	
	public static int displayMenu() {
		int option = 0;
		System.out.println("-----------------------------------------------\n");
		System.out.println("|      Welcome to the Football Database.      |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| Please select an option from the menu below:|\n");
		System.out.println("| 1.- League Menu                             |\n");
		System.out.println("| 2.- Team Menu                               |\n");
		System.out.println("| 3.- Player Menu                             |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| 4.- Exit                                    |\n");
		System.out.println("-----------------------------------------------\n");
		
		option = leer.nextInt();
		
		while (option < 1 || option > 4) {
			System.out.println("Please press options 1 to 4");
			option = leer.nextInt();
		}
		
		return option;
	}
	
	// League Menu code block.
	public static int leagueMenu() {
		int option;
		do {
			option = displayLeagueMenu();
			switch (option) {
			case 1:
				leagueFindAll();
				break;
			case 2:
				leagueFindById();
				break;
			case 3:
				leagueCreate();
				break;
			case 4: 
				leagueEdit();
				break;
			case 5:
				leagueDelete();
				break;
			}
		}while (option != 6);
			System.out.println("| Returning to main menu. |");
			
		
		return option;
		
	}
	
	public static int displayLeagueMenu() {
		int option = 0;
		System.out.println("-----------------------------------------------\n");
		System.out.println("|        Welcome to the League Menu.           |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| Please select an option from the menu below:|\n");
		System.out.println("| 1.- Find All Leagues                        |\n");
		System.out.println("| 2.- Find a League via ID Code               |\n");
		System.out.println("| 3.- Create a League                         |\n");
		System.out.println("| 4.- Edit a League                           |\n");
		System.out.println("| 5.- Delete a League                         |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| 6.- Go back                                 |\n");
		System.out.println("-----------------------------------------------\n");
		
		option = leer.nextInt();
		
		while (option < 1 || option > 6) {
			System.out.println("Please press from options 1 to 6.");
			option = leer.nextInt();
		}
		
		
		return option;
	}
	
	public static void leagueFindAll() {
		System.out.println("Here is a list of all the leagues in the database:\n");
		for(League ele: ldao.findAll()) {
			System.out.println("| " +ele.getLeagueName() + ", " + ele.getCountry() + ", Tier: " + ele.getTier() + " |");
		}
	}
	
	public static void leagueFindById() {
		System.out.println("| Please enter the league id code that you wish to search: |\n");
		int codeLeague = leer.nextInt();
		League ele = ldao.findById(codeLeague);
		System.out.println("| The search has returned the following league: " + ele.getLeagueName() + " |\n");
	}
	
	public static void leagueCreate() {
		System.out.println("| Please enter the details of the league you wish to insert. |\n");
		System.out.println("| Please enter the league Id code. |");
		int code = leer.nextInt();
		leer.nextLine();
		System.out.println("| Please enter the league name. |\n");
		String lName = leer.nextLine();
		System.out.println("| Please enter the league country. |\n");
		String country = leer.nextLine();
		System.out.println("| Please enter the league tier. |\n");
		int tier = leer.nextInt();
		League league1 = new League(code, lName, country, tier);
		System.out.println("| We are processing the insertion of the new league, I am hoping for a 1 and I have received a: " + ldao.insertOne(league1) + " |\n");
	}
	
	public static void leagueEdit() {
		System.out.println("| Please enter the ID code of the league you wish to modify:  |\n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("| Please enter the details you would like to modify. |\n");
		System.out.println("| Please enter the new league name. |\n");
		String name = leer.nextLine();
		System.out.println("| Please enter the new country. |\n");
		String country = leer.nextLine();
		System.out.println("| Please enter the new tier of the league. |\n");
		int tier = leer.nextInt();
		leer.nextLine();
		
		League league = new League(id, name, country, tier);
		System.out.println("We are processing the modification of the details of the requested league, I am hoping for a 1, and I have received a: " + ldao.updateOne(league));
	}
	
	public static void leagueDelete() {
		System.out.println("| Please enter the ID code of the league you wish to delete:  |\n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("We are processing the deletion of the requested league, I am hoping for a 1, and I have received a: " + ldao.deleteOne(id));	
	}
	
	// Team menu code block.
	public static int teamMenu() {
		int option;
		do {
			option = displayTeamMenu();
			switch(option) {
			case 1: 
				teamFindAll();
				break;
			case 2:
				teamFindById();
				break;
			case 3:
				teamCreate();
				break;
			case 4:
				teamEdit();
				break;
			case 5:
				teamDelete();
				break;
			}
		}while (option != 6);
		System.out.println("| Returning to main menu. |");
		
		return option;
	}
	
	public static int displayTeamMenu() {
		int option = 0;
		System.out.println("-----------------------------------------------\n");
		System.out.println("|        Welcome to the Team Menu.            |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| Please select an option from the menu below:|\n");
		System.out.println("| 1.- Find All Teams                          |\n");
		System.out.println("| 2.- Find a Team via ID Code                 |\n");
		System.out.println("| 3.- Create a Team                           |\n");
		System.out.println("| 4.- Edit a Team                             |\n");
		System.out.println("| 5.- Delete a Team                           |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| 6.- Go back                                 |\n");
		System.out.println("-----------------------------------------------\n");
		
		option = leer.nextInt();
		
		while (option < 1 || option > 6) {
			System.out.println("| Please press from options 1 to 6. |");
			option = leer.nextInt();
		}
		
		return option;
	}
	
	public static void teamFindAll() {
		System.out.println("| Here you have a complete list of all of the teams: |\n");
		for(Team ele: tdao.findAll()) {
			System.out.println("| " + ele.getTeamName() + ", " + ele.getCountry() + ", " + ele.getLeagueCode().getLeagueName() + ", " 
			+ ele.getLeagueCode().getCountry() + ", Tier: " + ele.getLeagueCode().getTier() + " |");
		}
	}
	
	public static void teamFindById() {
		System.out.println("| Please enter the team id code to search: |\n");
		int codeTeam = leer.nextInt();
		Team team = tdao.findById(codeTeam);
		System.out.println("| The search has returned the following team: " + team.getTeamName() + " |");
		leer.close();
	}
	
	public static void teamCreate() {
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
	
	public static void teamEdit() {
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
	
	public static void teamDelete() {
		System.out.println("Please enter the ID code of the team you wish to delete: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("We are processing the deletion of the requested team, I am hoping for a 1, and I have received a: " + tdao.deleteOne(id));
		leer.close();
	}
	
	//Player menu code block
	public static int playerMenu() {
		int option;
		
		do {
			option = displayPlayerMenu();
			switch(option) {
			case 1:
				playerFindAll();
				break;
			case 2:
				playerFindById();
				break;
			case 3:
				playerSearch();
				break;
			case 4:
				playerFindByTeam();
				break;
			case 5:
				playerFindByPosition();
				break;
			case 6:
				playerFindByShirtNumber();
				break;
			case 7:
				playerCreate();
				break;
			case 8:
				playerEdit();
				break;
			case 9:
				playerDelete();
				break;
			}
		}while (option != 10);
		System.out.println("| Returning to main menu. |");
		
		return option;
	}
	
	public static int displayPlayerMenu() {
		int option = 0;
		System.out.println("-----------------------------------------------\n");
		System.out.println("|        Welcome to the Player Menu.          |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| Please select an option from the menu below:|\n");
		System.out.println("| 1.- Find All Players                        |\n");
		System.out.println("| 2.- Find a Player via ID Code               |\n");
		System.out.println("| 3.- Search for a Player by Name             |\n");
		System.out.println("| 4.- Find a Player via Team                  |\n");
		System.out.println("| 5.- Find a Player via Position              |\n");
		System.out.println("| 6.- Find a Player via Shirt Number          |\n");
		System.out.println("| 7.- Create a Player                         |\n");
		System.out.println("| 8.- Edit a Player                           |\n");
		System.out.println("| 9.- Delete a Player                         |\n");
		System.out.println("-----------------------------------------------\n");
		System.out.println("| 10.- Go back                                |\n");
		System.out.println("-----------------------------------------------\n");
		
		option = leer.nextInt();
		
		while (option < 1 || option > 10) {
			System.out.println("| Please press from options 1 to 10. |");
			option = leer.nextInt();
		}
		
		return option;
	}
	
	public static void playerFindAll() {
		System.out.println("| Here you have a complete list of all of the players:  |\n");
		for(Player ele : pdao.findAll()) {
			System.out.println("| Player ID: " + ele.getPlayerCode() + " " + "Player Name: " + ele.getPlayerName() + " " + "Country: " + ele.getCountryOrigin() + " " 
			+ "Position: " + ele.getPosition() + " " + "Team: " + ele.getTeamId().getTeamName() + " " + "Shirt Number: " + ele.getShirtNumber() + " |");
		}
	}
	
	public static void playerFindById() {
		System.out.println("| Please enter the player's ID code:  |\n");
		int codePlayer = leer.nextInt();
		Player player = pdao.findById(codePlayer);
		System.out.println("Here is the player you requested: " + player.getPlayerName());
		leer.close();
	}
	
	public static void playerSearch() {
		System.out.println("Please enter the player's name, that you wish to search for: \n");
		String name = leer.nextLine();
		System.out.println("Here is a list of all the players that have been found: \n");
		for(Player ele: pdao.searchPlayer(name)) {
			System.out.println(ele.getPlayerName() + ", Team: " + ele.getTeamId().getTeamName());
		}
		leer.close();
	}
	
	public static void playerFindByTeam() {
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
	
	public static void playerFindByPosition() {
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
	
	public static void playerFindByShirtNumber() {
		System.out.println("Please enter the shirt number to see a list of players who wear that shirt number: \n");
		String number = leer.nextLine();
		System.out.println("Here is a list of player who wear the number " + number);
		for (Player ele: pdao.searchByShirtNumber(number)) {
			System.out.println(ele.getPlayerName() + ", Team: " + ele.getTeamId().getTeamName());
		}
		leer.close();
	}
	
	public static void playerCreate() {
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
	
	public static void playerEdit() {
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
	
	public static void playerDelete() {
		System.out.println("Please enter the player ID code for the player you wish to delete: \n");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("We are processing the deletion of the requested player, I should receive a 1, and I have received a: " + pdao.deleteOne(id));
		leer.close();
	}

}
