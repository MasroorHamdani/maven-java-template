package com.hashedin.movieRecommendation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class FileConnector {
	public Map<String,Movie> FileConnectingMovieFunction(String FileName){
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		MovieManager moviemanager= new MovieManager();
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream(FileName);
		moviesMap=convertInputStreamToMap(stream);
		return moviesMap;
	}
	
	public Map<String,Movie> convertInputStreamToMap(InputStream moviesInputStream){
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		try {
			List<String> lines = IOUtils.readLines(moviesInputStream);
			for(String line : lines){
				Movie m = new Movie();
				m = parseLine(line);
				moviesMap.put(m.getId(), m);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesMap;
	}

	public Movie parseLine(String line){
		StringTokenizer strToken = new StringTokenizer(line,"|");
		//System.out.println("strToken length "+strToken.countTokens());
		//System.out.println("strToken data "+strToken.nextToken());//.length());
		//System.out.println("strToken data "+strToken.nextToken().trim().length());
		
		Movie movie = new Movie();
		if(strToken.countTokens() == 23){
			if(strToken.hasMoreTokens()){
				//movie.setId(Integer.parseInt(strToken.nextToken()));
				movie.setId(strToken.nextToken());
				movie.setMovieName(strToken.nextToken());
				movie.setReleaseDate(strToken.nextToken());
				movie.setUrl(strToken.nextToken());
			}
		} else {
			System.out.println("Incomplete Movie Details");
		}
		return movie;
	}

	public ArrayList<Rating> FileConnectingRatingFunction(String FileName){
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		//MovieManager moviemanager= new MovieManager();
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream(FileName);
		RatingList = setRatings(stream);
		return RatingList;
	}
	public ArrayList<Rating> setRatings(InputStream RatingInputstream) {
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		try {
			List<String> lines = IOUtils.readLines(RatingInputstream);
			for(String line : lines){
				Rating rating = new Rating();
				rating = parseRatingFileLine(line);
				//RatingMap.put(rating.getId(), rating);
				RatingList.add(rating);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	/*	for (int i=0;i<RatingList.size();i++){
			System.out.println("list content "+RatingList.get(i));
		}*/
		return RatingList;
		
	}

	private Rating parseRatingFileLine(String line) {
		StringTokenizer strToken = new StringTokenizer(line);
		//System.out.println("strToken length "+strToken.countTokens());
		Rating rating = new Rating();
		if(strToken.countTokens() == 4){
			if(strToken.hasMoreTokens()){
				rating.setUserId(strToken.nextToken());
				rating.setId(strToken.nextToken());
				rating.setRating(strToken.nextToken());
			}
		}
		else {
			System.out.println("Incomplete Rating Details");
		}
		return rating;
	}

}
