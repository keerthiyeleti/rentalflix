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
	
		return movieList;
	}


	@Override
	public List<Movie> findByName(String name) {
		ArrayList<Movie> m = new ArrayList<Movie>();
		for(Movie i:movieList){
			if(i.getTitle()==name)
			{
				m.add(i);
			}
		}		
		return m;
	}

	@Override
	public Movie create(Movie movie) {
		movieList.add(movie);
		return movie;
	}

	@Override
	public  Movie update(Movie movie) {
		int c=0;
		for(Movie m: movieList)
		{
			if(movie.getId()==m.getId())
			{
				movieList.add(movie);
				c++;
			}
			
		}
	
		if(c==0)
			throw new IllegalArgumentException();
		return movie;
		}
	
	

	@Override
	public Movie delete(String id)
	{
		Movie m=null;
		Iterator<Movie> i=movieList.listIterator();
		l1:while(i.hasNext())
		{
			m=i.next();
			if(id==m.getId())
			{
				movieList.remove(m);
				break l1;
			}
			if(i.next()==null)
				throw new IllegalArgumentException();
		}
		return m;
		
		
	}

	@Override
	public boolean rentMovie(String movieId, String user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
