package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

public class MovieAccess {
public static void main(String args[])
{
	MovieService access=new MovieService();
	Movie movie = new Movie("1","up",2000,"english");
	Movie m;
	List<Movie> list=new ArrayList<Movie>();
	
	m=access.create(movie);
	System.out.println(m.getId()+m.getTitle()+m.getYear()+m.getLanguage());
	
	m=access.create(new Movie("2","frozen",2010,"english"));
	System.out.println(m.getId()+m.getTitle()+m.getYear()+m.getLanguage());

	m=access.create(new Movie("3","croods",2000,"english"));
	System.out.println(m.getId()+m.getTitle()+m.getYear()+m.getLanguage());
	
	m=access.delete("1");
	System.out.println(m.getId()+m.getTitle()+m.getYear()+m.getLanguage());

	list=access.findAll();
	for(Movie i:list)
		System.out.println(i.getId()+i.getTitle()+i.getYear()+i.getLanguage());
	
	try{
		list=access.findByName("up");
	
	for(Movie i:list)
		System.out.println(i.getId()+i.getTitle()+i.getYear()+i.getLanguage());
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(e);
    }
	
	access.update(new Movie("1","spider",2000,"english"));
	
	access.findAll();
	
	access.findByName("up");
	
	list=access.findByName("spider");
	for(Movie i:list)
		System.out.println(i.getId()+i.getTitle()+i.getYear()+i.getLanguage());
	
	m=access.delete("1");
	System.out.println(m.getId()+m.getTitle()+m.getYear()+m.getLanguage());
	

	list=access.findAll();
	for(Movie i:list)
		System.out.println(i.getId()+i.getTitle()+i.getYear()+i.getLanguage());
	
	
	
}
}
