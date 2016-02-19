package io.egen.rentalflix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	@Test
	public void testfindAll() {
	
		MovieService m=new MovieService();
		Movie exp1=m.create(new Movie("1","up",2000,"english"));
		Movie exp2=m.create(new Movie("2","frozen",2000,"english"));
		Movie exp3=m.create(new Movie("3","croods",2000,"english"));
		List<Movie> ls=new ArrayList<Movie>();
		ls.add(exp1);
		ls.add(exp2);
		ls.add(exp3);
		List<Movie> act=m.findAll();
		Assert.assertEquals(ls,act);
	}
		
	@Test
	public void testfindByName() {
		MovieService m=new MovieService();
		Movie exp1=m.create(new Movie("1","up",2000,"english"));
		Movie exp2=m.create(new Movie("2","frozen",2000,"english"));
		Movie exp3=m.create(new Movie("3","upcroods",2000,"english"));
		List<Movie> ls=new ArrayList<Movie>();
		ls.add(exp1);
		ls.add(exp3);
		List<Movie> act=m.findByName("up");
		Assert.assertEquals(ls,act);
	}
	
	@Test
	public void testcreate() {
		MovieService m=new MovieService();
		Movie exp=new Movie("1","up",2000,"english");
		Movie act=m.create(exp);
		Assert.assertEquals(exp,act);
	}
		
	@Test
	public void testupdate() {
		MovieService m=new MovieService();
		Movie exp1=m.create(new Movie("1","up",2000,"english"));
		Movie act=m.update(new Movie("1","update",2000,"english"));
		Assert.assertEquals("update",act.getTitle());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUpdateIllegalArguments()
	{
		MovieService m=new MovieService();
		Movie exp1=m.create(new Movie("1","up",2000,"english"));
		Movie act=m.update(new Movie("2","update",2000,"english"));
		
	}

	@Test
	public void testdelete()
	{
		MovieService m=new MovieService();
		Movie exp1=m.create(new Movie("1","up",2000,"english"));
		Movie exp2=m.create(new Movie("2","frozen",2000,"english"));
		Movie exp3=m.create(new Movie("3","croods",2000,"english"));
		Movie act=m.delete("2");
		Assert.assertEquals(exp2,act);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testDeleteIllegalArguments()
	{
		MovieService m=new MovieService();
		Movie exp1=m.delete("1");
	}

		

	

}
