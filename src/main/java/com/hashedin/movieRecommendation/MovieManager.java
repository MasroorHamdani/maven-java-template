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
	
	public static void addRatings(ArrayList<Rating> ratingList, Map<String, Movie> moviesMap) {
		Integer rate=0;
		for (Map.Entry<String, Movie> entry : moviesMap.entrySet())
		{
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
		    for(int i=0;i<ratingList.size();i++){
		    	if(ratingList.get(i).getId() == entry.getKey()){
		    		rate= Integer.parseInt(ratingList.get(i).getRating()) + rate;
		    	}
			}
		 //   moviesMap.put(entry.getKey(),moviesMap.get(entry.getKey())+1);
		 //   moviesMap.put(entry.getKey(), entry.getValue().setRatings(rate.toString()));
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
