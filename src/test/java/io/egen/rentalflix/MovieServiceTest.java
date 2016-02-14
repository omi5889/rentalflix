package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	private MovieService ms = null;
	
	@Before
	public void initialize(){
		ms = new MovieService();
		createMovieList();
	}
	
	@Test	
	public void testFindAll(){
		
		List<Movie> allList = processInputOutput();
		Assert.assertEquals(allList,ms.findAll());
	}
	
	@Test
	public void  testFindByName(){
		
		List<Movie> list = new ArrayList();
		
		Movie imdb1 = new Movie(1,"Shawshank Redemption","1994","English",false);
		Movie imdb2 = new Movie(2,"The Godfather","1972","English",false);
		Movie imdb3 = new Movie(3,"The Dark Knight","2008","English",false);
		list.add(imdb1);
		list.add(imdb2);
		list.add(imdb3);
		Assert.assertEquals(list,ms.findByName("The Godfather"));
		
	}
	
		
	@Test
	public void testCreate (){
		Movie imdb9 = new Movie(9,"Fight Club","1999","English",false);
		Assert.assertEquals(imdb9,ms.create(imdb9));
	}
	
	@Test
	public void testUpdate (){
		Movie imdb6 = new Movie(6,"12 Angry Men","1957","English",false);
		Assert.assertEquals(imdb6,ms.update(imdb6));
	}
	
	@Test
	public void testDelete (){
		Movie imdb4 = new Movie(4,"Pulp Fiction","1994","English",false);
		Assert.assertEquals(imdb4,ms.delete(4));
		
	}
	
	@Test
	public void testRentMovie (){
		Assert.assertEquals(true,ms.rentMovie(4,"Bruce"));
		Assert.assertEquals(false,ms.rentMovie(31,"Wayne"));
	}

	
	public void createMovieList(){
		
		Movie imdb1 = new Movie(1,"Shawshank Redemption","1994","English",false);
		Movie imdb2 = new Movie(2,"The Godfather","1972","English",false);
		Movie imdb3 = new Movie(3,"The Dark Knight","2008","English",false);
		Movie imdb4 = new Movie(4,"Pulp Fiction","1994","English",false);
		Movie imdb5 = new Movie(5,"Schindler's List","1993","English",false);
		Movie imdb6 = new Movie(6,"12 Angry Men","1957","English",false);
		
		
	    ms.hmap.put(1,imdb1);
	    ms.hmap.put(2,imdb2);
	    ms.hmap.put(3,imdb3);
	    ms.hmap.put(4,imdb4);
	    ms.hmap.put(5,imdb5);
	    ms.hmap.put(6,imdb6);
	    
	    
	}
	public List<Movie> processInputOutput(){
		Movie imdb1 = new Movie(1,"Shawshank Redemption","1994","English",false);
		Movie imdb2 = new Movie(2,"The Godfather","1972","English",false);
		Movie imdb3 = new Movie(3,"The Dark Knight","2008","English",false);
		Movie imdb4 = new Movie(4,"Pulp Fiction","1994","English",false);
		Movie imdb5 = new Movie(5,"Schindler's List","1993","English",false);
		Movie imdb6 = new Movie(6,"12 Angry Men","1957","English",false);
		
		
	    List<Movie> expectedOutput = new ArrayList<Movie>();
	    expectedOutput.add(imdb1);
	    expectedOutput.add(imdb2);
	    expectedOutput.add(imdb3);
	    expectedOutput.add(imdb4);
	    expectedOutput.add(imdb5);
	    expectedOutput.add(imdb6);
	    
	    return expectedOutput;
	}
	
}
