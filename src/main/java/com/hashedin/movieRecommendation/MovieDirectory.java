package com.hashedin.movieRecommendation;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MovieDirectory {
	private ArrayList<User> UserArray=new ArrayList<User>();
	private ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
	private ArrayList<Rating> RatingArray = new ArrayList<Rating>();
	public MovieDirectory(Map<String, Movie> moviesMap,
			ArrayList<Rating> ratingList, Map<String, User> userMap) {
		ArrayList<Movie> MoviesArray = new ArrayList(moviesMap.values());  
//		for (int i=0;i<MoviesArray.size();i++){
//			System.out.println("list content "+MoviesArray.get(i));
//		}
		ArrayList<User> UserArray = new ArrayList(userMap.values()); 
//		for (int i=0;i<UserArray.size();i++){
//			System.out.println("list content "+UserArray.get(i));

		RatingArray=ratingList;
		FilterActiveUser(UserArray);
	//	System.out.println("one ");
		FilterTopWatchedMovie(RatingArray);
	}
	private void FilterTopWatchedMovie(ArrayList<Rating> RatingArray) {
		ArrayList <String> movieRating = new ArrayList<String>();
		for(int i=0;i<RatingArray.size();i++){
			movieRating.add(RatingArray.get(i).getId());
		}
		String maxOccured=mostCommon(movieRating);
		System.out.println("Most watched movie "+ maxOccured);
		
	}
	public  String mostCommon(ArrayList <String> list) {
	    Map<String, Integer> mapCount = new HashMap<>();

	    for (String str : list) {
	        Integer val = mapCount.get(str);
	     //   System.out.println(val);
	        mapCount.put(str, val == null ? 1 : val + 1);
	    }
	    Entry<String, Integer> max = null;
	    for (Entry<String, Integer> entry : mapCount.entrySet()) {
	        if (max == null || entry.getValue() > max.getValue()){
	            max = entry;
	          //  System.out.println(max);
	        }
	    }
	    return max.getKey();
	}
	
	public void FilterActiveUser(ArrayList<User> User){
		int ratingCount=0;
		int UserId=0;
		for (User list : User){
			if(list.getCount()> ratingCount){
				ratingCount=list.getCount();
				UserId=Integer.parseInt(list.getUserId());
			}
		}
		System.out.println("Most Active User is "+User.get(UserId));
	}
	public void FilterTopMovieByYear(ArrayList<Movie> Movie){
		int ratingCount=0;
		int MovieId=0;
		for (Movie list : Movie){
			
			if(list.getCount()> ratingCount){
				ratingCount=list.getCount();
				//UserID=Integer.parseInt(list.getUserId());
			}
		}
	}
	
}
