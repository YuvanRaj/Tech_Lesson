package com.tech.encoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieComparator {

	public static void main(String[] args) {
		List<Movie> movieList = new ArrayList<Movie>();
	
		Movie movie = new Movie();
		
		Movie m1 = new Movie(5, "2012", "Kathi");
		Movie m2 = new Movie(6, "2011", "Thuppaki");
		Movie m3 = new Movie(1, "2013", "Vedhalam");
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		
		System.out.println("Before Iteration");
		for(Movie moviebefore : movieList){
			System.out.println("Movie Name "+moviebefore.getMovieName() +" Movie Rating \t"+moviebefore.getRating());
		}
		
		
		Collections.sort(movieList, movie);
		
		System.out.println("After Iteration");
		for(Movie moviebefore : movieList){
			System.out.println("Movie Name "+moviebefore.getMovieName() +" Movie Rating \t"+moviebefore.getRating());
		}
		
	}

}
