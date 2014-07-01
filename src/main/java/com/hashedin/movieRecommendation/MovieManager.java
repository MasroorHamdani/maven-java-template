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

	//Map<String,Movie> movies= new HashMap<String,Movie>();
	public static void main(String[] args) throws IOException {
		Map<Integer,Movie> moviesMap = new HashMap<Integer,Movie>();
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		MovieManager moviemanager= new MovieManager();
		// stream = MovieManager.class.getResourceAsStream("movie.data");
		 InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream("movie.data");
		 moviesMap=moviemanager.convertInputStreamToMap(stream);
		 //System.out.println("moviesMap "+ moviesMap);
		 stream = MovieManager.class.getClassLoader().getResourceAsStream("ratings.data");
		 RatingList = moviemanager.setRatings(stream);
		 stream = MovieManager.class.getClassLoader().getResourceAsStream("user.data");
		// moviemanager.setUsers(stream);
		// findRatings(RatingList);
		 addRatings(RatingList,moviesMap);
		
	}
	
public static void addRatings(ArrayList<Rating> ratingList, Map<Integer, Movie> moviesMap) {
		// TODO Auto-generated method stub
		
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

/*	public void setUsers(InputStream UserInputstream) {
		ArrayList<User> UserList = new ArrayList<User>();
		try {
			List<String> lines = IOUtils.readLines(UserInputstream);
			for(String line : lines){
				User user = new User();
				user = parseUserFileLine(line);
				//RatingMap.put(rating.getId(), rating);
				UserList.add(user);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//return RatingList;
		
	}*/

	public User parseUserFileLine(String line) {
		StringTokenizer strToken = new StringTokenizer(line,"|");
		//System.out.println("strToken length "+strToken.countTokens());
		User user= new User();
		if(strToken.countTokens() == 5){
			if(strToken.hasMoreTokens()){
				user.setUserId(strToken.nextToken());
			}
		}
		else {
			System.out.println("Incomplete Rating Details");
		}
		return user;
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
				//rating.setUserId(Integer.parseInt(strToken.nextToken()));
				//rating.setId(Integer.parseInt(strToken.nextToken()));
			//	rating.setRating(Integer.parseInt(strToken.nextToken()));
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

	public Map<Integer,Movie> convertInputStreamToMap(InputStream moviesInputStream){
		Map<Integer,Movie> moviesMap = new HashMap<Integer,Movie>();
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
		//System.out.println("strToken data "+strToken.nextToken().length());
		//System.out.println("strToken data "+strToken.nextToken().trim().length());
		
		Movie movie = new Movie();
		Rating rating= new Rating();
		if(strToken.countTokens() == 23){
			if(strToken.hasMoreTokens()){
				movie.setId(Integer.parseInt(strToken.nextToken()));
				movie.setMovieName(strToken.nextToken());
				movie.setReleaseDate(strToken.nextToken());
				movie.setUrl(strToken.nextToken());
			}
		} else {
			System.out.println("Incomplete Movie Details");
		}
		
		return movie;
	}
	

	
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
