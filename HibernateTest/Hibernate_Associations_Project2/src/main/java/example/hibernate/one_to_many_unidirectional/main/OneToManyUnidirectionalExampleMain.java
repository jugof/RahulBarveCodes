package example.hibernate.one_to_many_unidirectional.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.one_to_many_unidirectional.entity.CricketPlayer;
import example.hibernate.one_to_many_unidirectional.entity.CricketTeam;
import example.hibernate.one_to_many_unidirectional.utils.HibernateUtils;

public class OneToManyUnidirectionalExampleMain {
	private static void addCricketTeams() {
		// Add Some Teams
		CricketTeam indianTeam = 
				new CricketTeam("IND", "India", null);
		CricketTeam australianTeam = 
				new CricketTeam("AUS", "Australia", null);
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(indianTeam);
				sessionRef.persist(australianTeam);
			tx.commit();
			System.out.println("Teams created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void addCricketPlayers() {
		//Add Some Players
		CricketPlayer player1 = 
				new CricketPlayer("VK", "Virat Kohli", 35, 56.89f);
		CricketPlayer player2 = 
				new CricketPlayer("RS", "Rohit Sharma", 36, 46.89f);
		CricketPlayer player3 = 
				new CricketPlayer("PC", "Pat Cummins", 34, 36.89f);
		CricketPlayer player4 = 
				new CricketPlayer("GM", "Glenn Maxwell", 32, 50.89f);
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(player1);
				sessionRef.persist(player2);
				sessionRef.persist(player3);
				sessionRef.persist(player4);
			tx.commit();
			System.out.println("Players created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	private static void linkPlayersToTeams() {
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			//Find the teams
			CricketTeam team1 = sessionRef.find(CricketTeam.class, "IND");
			CricketTeam team2 = sessionRef.find(CricketTeam.class, "AUS");
			//Find the players
			CricketPlayer player1 = sessionRef.find(CricketPlayer.class, "VK");
			CricketPlayer player2 = sessionRef.find(CricketPlayer.class, "RS");
			CricketPlayer player3 = sessionRef.find(CricketPlayer.class, "PC");
			CricketPlayer player4 = sessionRef.find(CricketPlayer.class, "GM");
			
			//Link them
			Transaction tx = sessionRef.beginTransaction();
				team1.addPlayer(player1);
				team1.addPlayer(player2);
				
				//Set<CricketPlayer> playerSet = new HashSet<>();
				//playerSet.add(player3);
				//playerSet.add(player4);
				
				Set<CricketPlayer> playerSet = Set.of(player3, player4);
				team2.setPlayers(playerSet);
			tx.commit();
			System.out.println("Players linked to teams");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		//addCricketTeams();
		//addCricketPlayers();
		linkPlayersToTeams();

	}

}
