package com.hashedin.movieRecommendation;

/** Class for Test Cases
 *
 */
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MovieDirectory {
	private ArrayList<User> UserArray=new ArrayList<User>();
	private ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
	private ArrayList<Rating> RatingArray = new ArrayList<Rating>();
	public MovieDirectory(Map<String, Movie> moviesMap,
			ArrayList<Rating> ratingList, Map<String, User> userMap) {
		ArrayList<Movie> MoviesArray = new ArrayList(moviesMap.values());  
		ArrayList<User> UserArray = new ArrayList(userMap.values()); 
		RatingArray=ratingList;
		FilterActiveUser(UserArray);
		FilterTopWatchedMovie(RatingArray);
		//FilterTopMovieByYear(MoviesArray);
		FilterMoviesByGenre(MoviesArray);
	}
	/** Function for Filtering Data by Genre
	 * 
	 * @param ArrayList<Movie>
	 * @return void
	 */
	private void FilterMoviesByGenre(ArrayList<Movie> moviesArray) {
		Scanner scan= new Scanner(System.in);
		Integer genre=scan.nextInt();
		ArrayList<Movie> filtered= new ArrayList<Movie>();
		switch (genre){
			case 1: {
				filtered = FilterByEachGenre(1,moviesArray);
				break;
			}
			case 2: {
				filtered = FilterByEachGenre(2,moviesArray);
				break;
			}
			case 3: {
				filtered = FilterByEachGenre(3,moviesArray);
				break;
			}
			case 4: {
				filtered = FilterByEachGenre(4,moviesArray);
				break;
			}
			case 5: {
				filtered = FilterByEachGenre(5,moviesArray);
				break;
			}
			case 6: {
				filtered = FilterByEachGenre(6,moviesArray);
				break;
			}
			case 7: {
				filtered = FilterByEachGenre(7,moviesArray);
				break;
			}
			case 8: {
				filtered = FilterByEachGenre(8,moviesArray);
				break;
			}
			case 9: {
				filtered = FilterByEachGenre(9,moviesArray);
				break;
			}
			case 10: {
				filtered = FilterByEachGenre(10,moviesArray);
				break;
			}
			case 11: {
				filtered = FilterByEachGenre(11,moviesArray);
				break;
			}
			case 12: {
				filtered = FilterByEachGenre(12,moviesArray);
				break;
			}
			case 13: {
				filtered = FilterByEachGenre(13,moviesArray);
				break;
			}
			case 14: {
				filtered = FilterByEachGenre(14,moviesArray);
				break;
			}
			case 15: {
				filtered = FilterByEachGenre(15,moviesArray);
				break;
			}
			case 16: {
				filtered = FilterByEachGenre(16,moviesArray);
				break;
			}
			default:System.out.println("Invalid Choice");
            break;
		}
		//ArrayList<Movie> filtered = FilterByEachGenre("Action",moviesArray);
		String genreName= FilterSort(filtered);
		
	}
	/** Function for Sorting filtered data of movies
	 * 
	 * @param ArrayList<Movie>
	 * @return String name of genre
	 */
	private String FilterSort(ArrayList<Movie> newFilteredMovieList) {
		for(int i=0;i<newFilteredMovieList.size();i++){
			System.out.println(newFilteredMovieList.get(i));
		}
		String MovieName="";
		int ratingCount=0;
		int MovieId=0;
		int rating=0;
		int avg=0;
		for (Movie list : newFilteredMovieList){
			if(list.getRatings()/list.getRatings() > avg){
				avg=list.getRatings()/list.getRatings();
				MovieId=Integer.parseInt(list.getId());
				MovieName=list.getMovieName();
			}
		}
		//System.out.println(newFilteredMovieList.get(MovieId).getMovieName());
		System.out.println(MovieName);
		return null;
	}
	/** Function for Filtering Data by each Genre
	 * 
	 * @param ArrayList<Movie>
	 * @param genre name
	 * @return ArrayList<Movie> containing movies of particular genre only
	 */
	private ArrayList<Movie> FilterByEachGenre(Integer GenreVal,
			ArrayList<Movie> moviesArray) {
		ArrayList<Movie> newFilteredMovieList= new ArrayList<Movie>();
		for(Movie list : moviesArray){
			//System.out.println(list.getGenreList().get(0));
			if(list.getGenreList().get(GenreVal)==1){
				newFilteredMovieList.add(list);
			}
		}
		return newFilteredMovieList;
	}
	/** Function for Filtering by Top watched Movies
	 * 
	 * @param ArrayList<Rating>
	 * @return void
	 */
	private void FilterTopWatchedMovie(ArrayList<Rating> RatingArray) {
		ArrayList <String> movieRating = new ArrayList<String>();
		for(int i=0;i<RatingArray.size();i++){
			movieRating.add(RatingArray.get(i).getId());
		}
		String maxOccured=mostCommon(movieRating);
		System.out.println("Most watched movie "+ maxOccured);
		
	}
	
	/** Function for finding most common movie rated by users
	 * 
	 * @param ArrayList<String>
	 * @return String most rated movie
	 */
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
	
	/** Function for Filtering most Active User
	 * 
	 * @param ArrayList<User>
	 * @return void
	 */
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
	/** Function for Filtering movies By years
	 * 
	 * @param ArrayList<Movie>
	 * @return void
	 */
	public void FilterTopMovieByYear(ArrayList<Movie> Movie){
		int ratingCount=0;
		int MovieId=0;
		ArrayList<Integer> yearList=new ArrayList<Integer>();
		for (Movie list : Movie){
		
			String[] arr= list.getReleaseDate().split("-");
			for(int i=0;i<arr.length;i++){
				yearList.add(Integer.parseInt(arr[i]));
			}
			if(list.getCount()> ratingCount){
				ratingCount=list.getCount();
				//UserID=Integer.parseInt(list.getUserId());
			}
		}
	}
	
}
