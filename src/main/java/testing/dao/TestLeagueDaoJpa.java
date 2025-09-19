package testing.dao;

import java.util.Scanner;

import modelo.dao.LeagueDao;
import modelo.dao.LeagueDaoImplJpa;
import modelo.entities.League;

public class TestLeagueDaoJpa {
	private static LeagueDao ldao;
	static {
		ldao = new LeagueDaoImplJpa();
	}

	public static void main(String[] args) {
		findOne(); //Working
		//findAll(); //Working
		//insertOne(); //Working
		//updateOne(); //Working
		//deleteOne(); //Working

	}

	public static void findAll() {
		System.out.println("Here is a list of all the leagues in the database:\n");
		for(League ele: ldao.findAll()) {
			//System.out.println(ele);
			System.out.println(ele.getLeagueName() + ", " + ele.getCountry() + ", Tier: " + ele.getTier());
		}
	}
	
	public static void findOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the league id code that you wish to search: \n");
		int codeLeague = leer.nextInt();
		League ele = ldao.findById(codeLeague);
		System.out.println("The search has returned the following league: " + ele.getLeagueName());
		leer.close();
	}
	
	public static void insertOne() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Please enter the details of the league you wish to insert.\n");
		System.out.println("Please enter the league Id code.");
		int code = leer.nextInt();
		System.out.println("Please enter the league name.\n");
		String lName = leer.next();
		System.out.println("Please enter the league country.\n");
		String country = leer.next();
		System.out.println("Please enter the league tier.\n");
		int tier = leer.nextInt();
		League league1 = new League(code, lName, country, tier);
		System.out.println("We are processing the insertion of the new league, I am hoping for a 1 and I have received a: " + ldao.insertOne(league1));
		leer.close();
	}
	
	public static void updateOne() {
		League league1 = new League(5, "LALIGA", "SPAIN", 1);
		System.out.println("We are processing the modification of the desired league, I am hoping for a 1 and I have received a: " + ldao.updateOne(league1));
	}
	
	public static void deleteOne() {
		System.out.println("We are processing the deletion of a league, I am hoping for a 1, and I have received a: " + ldao.deleteOne(5));
	}
}
