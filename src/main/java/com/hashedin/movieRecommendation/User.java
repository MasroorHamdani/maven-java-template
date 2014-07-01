package com.hashedin.movieRecommendation;

public class User {
	private String UserId;
	private Integer count;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", count=" + count + "]";
	}
	
}
