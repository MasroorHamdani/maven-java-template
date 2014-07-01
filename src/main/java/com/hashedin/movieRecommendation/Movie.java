package com.hashedin.movieRecommendation;

public class Movie {
	
	private Integer Id;
	private String MovieName;
	private String url;
	private String ReleaseDate;
	private String Ratings;
	public String getRatings() {
		return Ratings;
	}
	public void setRatings(String ratings) {
		Ratings = ratings;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", MovieName=" + MovieName + ", url=" + url
				+ ", ReleaseDate=" + ReleaseDate + "]";
	}
}
