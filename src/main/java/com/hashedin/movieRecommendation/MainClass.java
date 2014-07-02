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
		Map<String,User> UserMap=new HashMap<String,User>();
		FileConnector fileconnector=new FileConnector();
		String FileName="movie.data";
		moviesMap = fileconnector.FileConnectingMovieFunction(FileName);
		MovieManager moviemanager= new MovieManager();
		FileName="ratings.data";
		RatingList = fileconnector.FileConnectingRatingFunction(FileName);
		FileName="user.data";
		UserMap=fileconnector.FileConnectingUserFunction(FileName);
//		for (int i=0;i<RatingList.size();i++){
//			System.out.println("list content "+RatingList.get(i));
//		}
		//System.out.println("genre "+RatingList);
		moviemanager.addRatings(RatingList,moviesMap,UserMap);
		MovieDirectory movieDirectory=new MovieDirectory(moviesMap,RatingList,UserMap);
		
		
	}

}
