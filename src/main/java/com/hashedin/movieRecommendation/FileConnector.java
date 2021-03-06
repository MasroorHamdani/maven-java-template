package com.hashedin.movieRecommendation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

/** Class for Geting data from Files**/

public class FileConnector {
	/** Function for connecting with Movie Function
	 * 
	 * @param FileName file name to be accessed
	 * @return HashMap containing <String, Movie>
	 */
	public Map<String,Movie> FileConnectingMovieFunction(String FileName){
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		MovieManager moviemanager= new MovieManager();
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream(FileName);
		moviesMap=convertInputStreamToMap(stream);
		//System.out.println(moviesMap);
		return moviesMap;
	}
	
	/** Function for Converting input stream into a map
	 * 
	 * @param Path of file to ba accessed
	 * @return  hashmap of type <String, Movie>
	 */
	public Map<String,Movie> convertInputStreamToMap(InputStream moviesInputStream){
		Map<String,Movie> moviesMap = new HashMap<String,Movie>();
		try {
			List<String> lines = IOUtils.readLines(moviesInputStream);
			for(String line : lines){
				Movie movies = new Movie();
				movies = parseLine(line);
				//System.out.println(movies.getId()!= null);
				//if(movies.getId()!= null){
					moviesMap.put(movies.getId(), movies);
				//}
				//System.out.println("genre "+moviesMap);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(moviesMap);
		return moviesMap;
	}

	/** Function for parsing a file
	 * 
	 * @param FileName file name to be accessed
	 * @return Object of type Movie
	 */
	public Movie parseLine(String line){
		StringTokenizer strToken = new StringTokenizer(line,"|");
		//System.out.println("strToken length "+strToken.countTokens());
		//System.out.println("strToken data "+strToken.nextToken());//.length());
		//System.out.println("strToken data "+strToken.nextToken().trim().length());
		ArrayList<Integer> GenreList= new ArrayList<Integer>();
		Movie movie = new Movie();
		int i=0;
	//	if(strToken.countTokens() == 23){
			if(strToken.hasMoreTokens()){
				movie.setId(strToken.nextToken());
				movie.setMovieName(strToken.nextToken());
				movie.setReleaseDate(strToken.nextToken());
				movie.setUrl(strToken.nextToken());
				i=i+4;
				//GenreList=createGenre(strToken,i);
				while(i<23){
					if(strToken.hasMoreTokens()){
						GenreList.add(Integer.parseInt(strToken.nextToken()));
					}
					i++;
				}
				movie.setGenreList(GenreList);
			}
	//	} else {
		//	System.out.println("Incomplete Movie Details");
		//}
			//System.out.println("genre "+movie);
		return movie;
	}

	/** Function for Generating Arraylist of genre
	 * 
	 * @param StringTkenizer containing line of file 
	 * @param int variable for maintaining data
	 * @return ArrayList<Integer>
	 */
	private ArrayList<Integer> createGenre(StringTokenizer strToken ,int i) {
		ArrayList<Integer> GenreList= new ArrayList<Integer>();
		while(i<23){
			if(strToken.hasMoreTokens()){
				GenreList.add(Integer.parseInt(strToken.nextToken()));
			}
			i++;
		}
		return GenreList;
	}

	/** Function for connecting with Rating File
	 * 
	 * @param FileName file name to be accessed
	 * @return ArrayList containing <Rating>
	 */
	public ArrayList<Rating> FileConnectingRatingFunction(String FileName){
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		//MovieManager moviemanager= new MovieManager();
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream(FileName);
		//System.out.print(stream);
		RatingList = setRatings(stream);
		//System.out.println(RatingList);
		/*for (int i=0;i<RatingList.size();i++){
			System.out.println("list content "+RatingList.get(i));
		}*/
		return RatingList;
	}
	/** Function for setting values of Rating values in anarray list
	 * 
	 * @param InputStream i.e; path of file
	 * @return ArrayList<Rating>
	 */
	public ArrayList<Rating> setRatings(InputStream RatingInputstream) {
		ArrayList<Rating> RatingList = new ArrayList<Rating>();
		try {//int i=0;
			List<String> lines = IOUtils.readLines(RatingInputstream);
			for(String line : lines){
				
				Rating rating = new Rating();
				rating = parseRatingFileLine(line);
				//RatingMap.put(rating.getId(), rating);
				//System.out.println(rating+ " end");
				if(rating != null){
					RatingList.add(rating);
				}
				//System.out.println(RatingList.get(i));i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return RatingList;
		
	}

	/** Function for parsing a file
	 * 
	 * @param FileName file name to be accessed
	 * @return Object of type Rating
	 */
	private Rating parseRatingFileLine(String line) {
		StringTokenizer strToken = new StringTokenizer(line);
		//System.out.println("strToken length "+strToken.countTokens());
		Rating rating = new Rating();
		//if(strToken.countTokens() == 4){
			if(strToken.hasMoreTokens()){
				rating.setUserId(strToken.nextToken());
				rating.setId(strToken.nextToken());
				rating.setRating(strToken.nextToken());
			}
		//} else {
		//	System.out.println("Incomplete Rating Details");
		//}
		return rating;
	}

	/** Function for connecting with User File
	 * 
	 * @param FileName file name to be accessed
	 * @return HashMap containing <String, User>
	 */
	public Map<String, User> FileConnectingUserFunction(String fileName) {
		Map<String,User> userMap = new HashMap<String,User>();
		InputStream stream = MovieManager.class.getClassLoader().getResourceAsStream(fileName);
		userMap=setUsers(stream);
		
		return userMap;
	}
	
	public Map<String, User> setUsers(InputStream UserInputstream) {
		Map<String, User> userMap= new HashMap<String, User>();
		try {
			List<String> lines = IOUtils.readLines(UserInputstream);
			for(String line : lines){
				User user = new User();
				user = parseUserFileLine(line);
				userMap.put(user.getUserId(), user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	//System.out.println("UserMap "+userMap);
	return userMap;
	
}

	/** Function for parsing a file
	 * 
	 * @param FileName file name to be accessed
	 * @return Object of type User
	 */
	public User parseUserFileLine(String line) {
		StringTokenizer strToken = new StringTokenizer(line,"|");
		//System.out.println("strToken length "+strToken.countTokens());
		User user= new User();
		if(strToken.countTokens() == 5){
			if(strToken.hasMoreTokens()){
				user.setUserId(strToken.nextToken());
				user.setAge(Integer.parseInt(strToken.nextToken()));
				user.setGender(strToken.nextToken());
				user.setJob(strToken.nextToken());
			}
		}
		else {
			System.out.println("Incomplete Rating Details");
		}
		return user;
	}

}
