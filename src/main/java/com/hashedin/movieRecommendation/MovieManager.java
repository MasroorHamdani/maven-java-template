package com.hashedin.movieRecommendation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class MovieManager {
	/** Function for Finding Ratings for movies and setting its value in objects
	 * 
	 * @param ArrayList<Rating> 
	 * @param Map<String, Movie>
	 * @param Map<String, User>
	 * @return void
	 */
	public void addRatings(ArrayList<Rating> ratingList, Map<String, Movie> moviesMap, Map<String, User> userMap) {
		Integer rate;;
		ArrayList<Movie> tempMovieList = new ArrayList<Movie>();
		rate=0;
		User user;
		Movie movieList;
		for(Rating list : ratingList){
			movieList=moviesMap.get(list.getId());
			try{
			//	System.out.println(moviesMap);
			//	if(movieList.getRatings() != null && list.getRating() != null){
					movieList.setRatings(movieList.getRatings()+Integer.parseInt(list.getRating()));
			//	}
				}catch(Exception ex){
				ex.printStackTrace();
			}
			movieList.setCount(movieList.getCount()+1);
			user = userMap.get(list.getUserId());
			user.setCount(user.getCount()+1);
			//System.out.println("Rating= "+movieList);
		}
	}
}
