package com.hashedin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hashedin.movieRecommendation.FileConnector;
import com.hashedin.movieRecommendation.Movie;
import com.hashedin.movieRecommendation.MovieDirectory;
import com.hashedin.movieRecommendation.MovieManager;
import com.hashedin.movieRecommendation.Rating;
import com.hashedin.movieRecommendation.User;

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
    	/*	
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		FileConnector fileconnector=new FileConnector();
		String FileName="testMovie.data";
		moviesMap = fileconnector.FileConnectingMovieFunction(FileName);
		MovieManager moviemanager= new MovieManager();
		FileName="testRatings.data";
		RatingList = fileconnector.FileConnectingRatingFunction(FileName);
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("user.data");*/
    	Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		Map<String,User> UserMap=new HashMap<String,User>();
		FileConnector fileconnector=new FileConnector();
		String FileName="movie.data";
		moviesMap = fileconnector.FileConnectingMovieFunction(FileName);
		
		MovieManager moviemanager= new MovieManager();
		FileName="ratings.data";
		RatingList = fileconnector.FileConnectingRatingFunction(FileName);
		FileName="user.data";
		UserMap=fileconnector.FileConnectingUserFunction(FileName);
		moviemanager.addRatings(RatingList,moviesMap,UserMap);
		MovieDirectory movieDirectory=new MovieDirectory(moviesMap,RatingList,UserMap);
    	
		assertEquals(3,moviesMap.size());
		assertEquals(100000,RatingList.size());
		
		//assertEquals("474", MovieDirectory.FilterTopWatchedMovie(RatingList));
	}
}
