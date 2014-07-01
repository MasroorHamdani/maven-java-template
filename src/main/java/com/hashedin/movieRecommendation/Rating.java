package com.hashedin.movieRecommendation;

//user id | item id | rating | timestamp. 
public class Rating {
	private String UserId;
	private String Id;
	private String Rating;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	@Override
	public String toString() {
		return "Rating [UserId=" + UserId + ", Id=" + Id + ", Rating=" + Rating
				+ "]";
	}
	
}
