package io.egen.rentalflix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
 
	ArrayList<Movie> movieStore = new ArrayList<Movie>();
	

	/**
	 * Finds all available movies in the movie store
	 * @return list of movies or empty list
	 */
	@Override
	public List<Movie> findAll() {
	
		return movieStore;
	}

	/**
	 * Finds all movies in the movie store which contains <strong>name</strong> in the title
	 * @param name String
	 * @return list of movies or empty list
	 */
	@Override
	public List<Movie> findByName(String name) {
		ArrayList<Movie> resultSet = new ArrayList<Movie>();
		Iterator<Movie> ms=movieStore.listIterator();
		Movie temp=null;
		while(ms.hasNext()) 
		{  
			temp=ms.next();
			if(name==temp.getTitle())
			{   
				resultSet.add(temp); // Add Matched movies to the list
			}
			
		}
		return resultSet;  // Movie store empty or Movie is not found
	}

	
	/**
	 * Create a new movie in the movie store
	 * @param movie
	 * @return Movie
	 */
	@Override
	public Movie create(Movie movie) {
		
		if(findById(movie.getId()) == null){ // Check if the Movie is new and Add it
			movieStore.add(movie);
			return movie;
		}
		return findById(movie.getId()); // Return the existing Movie
		
		
	}

	
	/**
	 * Update an existing movie
	 * @param movie
	 * @return updated movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	@Override
	public  Movie update(Movie movie) {
		
		if(findById(movie.getId()) != null){ // Movie with this Id found
			movieStore.remove(movie); //Remove the existing
			movieStore.add(movie);    //Add the updated Movie
			return movie;
		}
		else{
			 throw new IllegalArgumentException();
		}
			
	}
	
	/**
	 * Delete an existing movie 
	 * @param id
	 * @return deleted movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */

	@Override
	public Movie delete(String id)
	{  
	   // Check if the Movie exists in Movie Store with this ID
		Movie toRemove=findById(id);
		
		
		if(toRemove!=null){ 
			movieStore.remove(toRemove); // Delete the movie from the movie store list.
			return toRemove;
		}
		else{
			 throw new IllegalArgumentException();
		}
		
		
	}
	
	/**
	 * Rent the movie with movieId to the <strong>user</strong>.
	 * Make sure this movie is not rented already. 
	 * If it is already rented, throw <strong>IllegalArgumentException</strong>
	 * @param movieId
	 * @param user
	 * @return true: if movie can be rented, false otherwise
	 */
	@Override
	public boolean rentMovie(String movieId, String user) {
		Movie rental=findById(movieId);
		
		if(rental==null){ // Not an existing movie
			throw new IllegalArgumentException();
		}
		if(rental.getIsRented()==Boolean.TRUE){
			
			return false; // Already Rented to someone
			
		}
		else {
			rental.setRentedUser(user);
			rental.setIsRented(Boolean.TRUE);
			return true; // Movie not rented.
		}
	}
	
	/**
	 * Utilty method created to find the existance of movie in the Store
	 * Used in other methods which are implementing IFLix interface
	 * Make sure this movie is not rented already. 
	 * If it is already rented, throw <strong>IllegalArgumentException</strong>
	 * @param movieid
	 * @return Movie if found, null if not found
	 */
	
	public Movie findById(String id){
		Movie temp=null;
		Iterator<Movie> ms=movieStore.listIterator();
		
		while(ms.hasNext()) 
		{  
			temp=ms.next();
			if(id==temp.getId())
			{   
				return temp; // Movie store list not empty and Movie is found
			}
			
		}
		return null;  // Movie store empty or Movie is not found
	}
	
	
}
