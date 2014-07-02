package com.hashedin.movieRecommendation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) throws IOException {
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		FileConnector fileconnector=new FileConnector();
		String FileName="movie.data";
		moviesMap = fileconnector.FileConnectingMovieFunction(FileName);
		MovieManager moviemanager= new MovieManager();
		/*	InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("movie.data");
		moviesMap=moviemanager.convertInputStreamToMap(stream);*/
	//	System.out.println("moviesMap "+ moviesMap);
		FileName="ratings.data";
		/*InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("ratings.data");
		RatingList = moviemanager.setRatings(stream);*/
		RatingList = fileconnector.FileConnectingRatingFunction(FileName);
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("user.data");
		// moviemanager.setUsers(stream);
		// findRatings(RatingList);
		//addRatings(RatingList,moviesMap);
		
	}

}
