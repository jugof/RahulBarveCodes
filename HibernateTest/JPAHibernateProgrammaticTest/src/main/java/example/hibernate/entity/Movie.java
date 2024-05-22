package example.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//Marks this class as an Entity Class
@Table(name = "Movie_Master")//Specifies the table name to which this class is to be mapped
public class Movie {
	@Id //Marks this field as an identity
	@Column(name = "movie_id")
	private int movieId;//Integer implements Serializable
	@Column(name = "movie_title", length = 50)
	private String title;
	@Column(name = "movie_genre", length = 30)
	private String genre;
	@Column(name = "movie_year")
	private int year;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(int movieId, String title, String genre, int year) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
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
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", year=" + year + "]";
	}

}
