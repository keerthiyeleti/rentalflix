package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieTest {
	

	
public static void main(String args[])
{  
	
	MovieService movieservice1=new MovieService();
	
	Movie temp=movieservice1.create(new Movie("1","Title1",2010,"English") );
	
	//System.out.println(temp);
	
	//printMovieService(movieservice1);
	 temp=movieservice1.create(new Movie("2","Title2",2002,"English") );
	 printMovieService(movieservice1.findAll());
	 System.out.println("\n \n **** Two Movies Added");
	 temp=movieservice1.create(new Movie("3","Title3",2003,"English") );
	 movieservice1.delete("3");
	 System.out.println("\n \n **** After Deleting Third Movie");
	 printMovieService(movieservice1.findAll());
	 temp=movieservice1.update(new Movie("2","Title2 Updated",2002,"English") );
	 System.out.println("\n \n **** After Updating Second Movie");
	 printMovieService(movieservice1.findAll());
	 
	 System.out.println("\n \n **** Printing movies which contain Title");
	 printMovieService(movieservice1.findByName("Upd"));
	 
	 
	 
}

public static void printMovieService(List<Movie> allmovies){

	
	for(Movie m:allmovies)
	{
		System.out.println(m);
	
	}
	
	}

}
