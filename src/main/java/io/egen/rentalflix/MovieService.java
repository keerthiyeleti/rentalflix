package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
 
	ArrayList<Movie> movieList = new ArrayList<Movie>();

	@Override
	public List<Movie> findAll() {
	
		return null;
	}


	@Override
	public List<Movie> findByName(String name) {
		
		return null;
	}

	@Override
	public Movie create(Movie movie) {
		movieList.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		
		return null;
	}

	@Override
	public Movie delete(String id)
	{
		Movie m=null;
		Iterator<Movie> i=movieList.listIterator();
		while(i.hasNext())
		{
			m=i.next();
			if(id==m.getId())
			{
				movieList.remove(m);
				break;
			}
		}
		
		return m;
			
	}

	@Override
	public boolean rentMovie(String movieId, String user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
