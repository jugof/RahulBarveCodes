package example.hibernate.many_to_many_bidirectional.entiry;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie_Details")
public class Movie {
	@Id 
	@Column(name = "movie_id")
	private int movieId;
	@Column(name = "movie_title", length = 50)
	private String title;
	@Column(name = "movie_genre", length = 30)
	private String genre;
	@Column(name = "movie_year")
	private int year;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Movie_Actor_Details",
			joinColumns = {@JoinColumn(name = "m_id")},
			inverseJoinColumns = {@JoinColumn(name = "a_id")}
			)
	private Set<Actor> actors;//This indicates OWNING side of the association.
	public Movie() {
		actors = new HashSet<Actor>();
	}
	public Movie(int movieId, String title, String genre, int year, Set<Actor> actors) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.actors = actors;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Set<Actor> getActors() {
		return actors;
	}
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
		for(Actor currentActor : actors)
			currentActor.addMovie(this);//this -> Current Movie object
			
	}
	public void addActor(Actor actorRef) {
		actors.add(actorRef);
		actorRef.addMovie(this);//this -> Current Movie object
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", year=" + year + ", actors="
				+ actors + "]";
	}

	
	  @Override public int hashCode() { 
		  //return Objects.hash(actors, genre, movieId,title, year);
		  return title.length() + year;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(genre, other.genre) && movieId == other.movieId
				&& Objects.equals(title, other.title) && year == other.year;
	}
	
}
