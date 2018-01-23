package com.tech.encoding;

import java.util.Comparator;

public class Movie implements Comparator<Movie> {
	
	public static int increment;
	
	public int rating;
	public String year;
	public String movieName;

	public Movie(){
		
	}
	
	public Movie(int rating, String year, String movieName) {
		this.rating = rating;
		this.year = year;
		this.movieName = movieName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public int compare(Movie m1, Movie m2) {
		increment++;
		System.out.println("Calling "+increment+" time " + m1.getMovieName());
		System.out.println("Calling "+increment+" time " + m2.getMovieName());
		if(m1.getRating() > m2.getRating()){
			return 1;
		}
		else if(m1.getRating() < m2.getRating()){
			return -1;
		}
		else {
			return 0;
		}
	}

}
