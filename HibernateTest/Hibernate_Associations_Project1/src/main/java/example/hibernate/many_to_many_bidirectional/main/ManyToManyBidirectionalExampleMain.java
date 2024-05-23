package example.hibernate.many_to_many_bidirectional.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.many_to_many_bidirectional.entiry.Actor;
import example.hibernate.many_to_many_bidirectional.entiry.Movie;
import example.hibernate.many_to_many_bidirectional.utils.HibernateUtils;

public class ManyToManyBidirectionalExampleMain {
	private static void addSomeMovies() {
		//Store some movies
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Movie movie1 = new Movie(101, "Mr. India", "Fantasy", 1988, null);
			Movie movie2 = new Movie(102, "Fighter", "Action",2024 , null);
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(movie1);
				sessionRef.persist(movie2);
			tx.commit();
			System.out.println("Movies created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void addSomeActors() {
		//Store some actors
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Actor actor1 = new Actor("a01", "Anil Kapoor", 63, null);
			Actor actor2 = new Actor("a02", "Hritik Roshan", 51, null);
			Actor actor3 = new Actor("a03", "Deepika Padukone", 39, null);
			Actor actor4 = new Actor("a04", "Sridevi", 65, null);
			
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(actor1);
				sessionRef.persist(actor2);
				sessionRef.persist(actor3);
				sessionRef.persist(actor4);
			tx.commit();
			System.out.println("Actors created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void linkActorsToMovies() {
		//Link actors to movies
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			//Fetching Movies
			Movie movie1 = sessionRef.find(Movie.class, 101);
			Movie movie2 = sessionRef.find(Movie.class, 102);
			//Fetching Actors
			Actor actor1 = sessionRef.find(Actor.class, "a01");
			Actor actor2 = sessionRef.find(Actor.class, "a02");
			Actor actor3 = sessionRef.find(Actor.class, "a03");
			Actor actor4 = sessionRef.find(Actor.class, "a04");
			//Linking Actors to Movies
			
			Transaction tx = sessionRef.beginTransaction();
				movie1.addActor(actor1);
				movie1.addActor(actor4);
					
				movie2.addActor(actor1);
				movie2.addActor(actor2);
				movie2.addActor(actor3);
			tx.commit();
			System.out.println("Actors linked with Movies.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//addSomeMovies();
		//addSomeActors();
		linkActorsToMovies();
		

	}

}
