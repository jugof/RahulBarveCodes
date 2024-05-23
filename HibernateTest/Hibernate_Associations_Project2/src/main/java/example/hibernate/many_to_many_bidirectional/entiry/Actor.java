package example.hibernate.many_to_many_bidirectional.entiry;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Actor_Details")
public class Actor {
	@Id
	@Column(name = "actor_id")
	private String actorId;
	@Column(name = "actor_name")
	private String name;
	@Column(name = "actor_age")
	private int age;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "actors")//This indicates the INVERSE side of the association
	private Set<Movie> movies;
	public Actor() {
		movies = new HashSet<Movie>();
	}
	public Actor(String actorId, String name, int age, Set<Movie> movies) {
		super();
		this.actorId = actorId;
		this.name = name;
		this.age = age;
		this.movies = movies;
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	public void addMovie(Movie movieRef) {
		movies.add(movieRef);
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + name + ", age=" + age + ", movies=" + movies + "]";
	}

	
	  @Override public int hashCode() {
		  //return Objects.hash(actorId, age, movies, name); }
		  return name.length() + age;
	  }
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(actorId, other.actorId) && age == other.age && Objects.equals(movies, other.movies)
				&& Objects.equals(name, other.name);
	}

}
