package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */



public class MovieService implements IFlix {
	 public static Hashtable<Integer,Movie> hmap = new Hashtable<Integer,Movie>();
	 
	 public List<Movie> findAll(){
		 List<Movie> movieList = new ArrayList<Movie>();	 
			 
		 for(Map.Entry<Integer, Movie> movies: hmap.entrySet()){			  
			 movieList.add(movies.getValue()); 
		 }
		 
		 return movieList;
	 }
	 
	 public List<Movie> findByName (String name){
		 List<Movie> movieList = new ArrayList<Movie>();
		 for(Map.Entry<Integer, Movie> movies: hmap.entrySet()){
			 if(name.equalsIgnoreCase(movies.getValue().getTitle())){
				 movieList.add(movies.getValue());				 
			 }
		 }
		 
		 
		 return movieList;
	 }
	 
	 public Movie create (Movie movie){
				
		hmap.put(movie.getId(), movie);
		return movie;		
		
	 }
	 
	 public Movie update(Movie movie){
		 for(Map.Entry<Integer, Movie> movies: hmap.entrySet()){
			 if(movie.getTitle().equalsIgnoreCase(movies.getValue().getTitle())){
				 synchronized(movies.getKey()){
					 movies.getValue().setId(movie.getId());
					 movies.getValue().setTitle(movie.getTitle());
					 movies.getValue().setLanguage(movie.getLanguage());
					 movies.getValue().setYear(movie.getYear());
					 return movies.getValue();
				 }
			 }			 
		 }
		 
			 throw new IllegalArgumentException();
	 }
	 
	 public Movie delete(int id) {
		 Movie deletedMovie=null;
		 int deletedKey=-1;
		 if(hmap.containsKey(id)){
			 synchronized(hmap.get(deletedKey)){
				 deletedMovie = hmap.get(deletedKey);
				 hmap.remove(deletedKey);
				 return deletedMovie;
			 }
			 
		 }
		 else
			 throw new IllegalArgumentException();		 
		 
	 }
	 
	 public boolean rentMovie (int movieId, String user){
		 for(Map.Entry<Integer, Movie> movies: hmap.entrySet()){
			 if(movieId==movies.getKey()){
				 return movies.getValue().isRented();				 
			 }
		 }
		 return false;
	 }
	 
	 
	 
	 
}
