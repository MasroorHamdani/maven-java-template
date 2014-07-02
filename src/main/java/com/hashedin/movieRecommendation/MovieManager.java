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
	
	public void addRatings(ArrayList<Rating> ratingList, Map<String, Movie> moviesMap, Map<String, User> userMap) {
		Integer rate;;
		ArrayList<Movie> tempMovieList = new ArrayList<Movie>();
		rate=0;
		User user;
		Movie movieList;
		for(Rating list : ratingList){
			movieList=moviesMap.get(list.getId());
			movieList.setRatings(movieList.getRatings()+Integer.parseInt(list.getRating()));
			movieList.setCount(movieList.getCount()+1);
			user = userMap.get(list.getUserId());
			user.setCount(user.getCount()+1);
			System.out.println("Rating= "+movieList);
		}
	}

/*	public static void findRatings(ArrayList<Rating> ratingList) {
		int count=0;
		for(int j=1;j<943;j++){
			for(int i=0;i<ratingList.size();i++){
				if(ratingList.get(i)==1){
					count++;
				}
			}
		}
		
	}*/

	/*private void getMovieList() throws IOException {
		Movie movie = new Movie();
		InputStream stream =  getClass().getClassLoader().getResourceAsStream("movie.data");
		System.out.println("Stream "+stream);
		movie=parseLine(stream);
		
	}*/
	/*private Movie parseLine(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		Movie movie=new Movie();
		System.out.println("readLine "+br.readLine());
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println ("strline "+strLine);
		  StringTokenizer strToken = new StringTokenizer(strLine,"|");
		  //System.out.println ("token "+strToken);
		  movie.setId(strToken.nextToken());
		  movie.setMovieName(strToken.nextToken());
		  movie.setReleaseDate(strToken.nextToken());
		  movie.setUrl(strToken.nextToken());
		}
		
		return movie;
	}*/

}
