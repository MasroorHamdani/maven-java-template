package com.hashedin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hashedin.movieRecommendation.Movie;
import com.hashedin.movieRecommendation.MovieManager;
import com.hashedin.movieRecommendation.Rating;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		MovieManager moviemanager= new MovieManager();
		// stream = MovieManager.class.getResourceAsStream("movie.data");
		 InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("testMovie.data");
		 moviesMap=moviemanager.convertInputStreamToMap(stream);
		 //System.out.println("moviesMap "+ moviesMap);
		 stream = MovieManager.class.getClassLoader().getResourceAsStream("testRatings.data");
		 RatingList = moviemanager.setRatings(stream);
		 assertEquals(3,moviesMap.size());
		 assertEquals(100000,RatingList.size());
		 
    }
    
}
