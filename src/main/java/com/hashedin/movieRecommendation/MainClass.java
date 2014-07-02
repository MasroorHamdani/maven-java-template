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
		Map<String,User> UserList=new HashMap<String,User>();
		FileConnector fileconnector=new FileConnector();
		String FileName="movie.data";
		moviesMap = fileconnector.FileConnectingMovieFunction(FileName);
		MovieManager moviemanager= new MovieManager();
		FileName="ratings.data";
		RatingList = fileconnector.FileConnectingRatingFunction(FileName);
		FileName="user.data";
		UserList=fileconnector.FileConnectingUserFunction(FileName);
		moviemanager.addRatings(RatingList,moviesMap,UserList);
		
	}

}
