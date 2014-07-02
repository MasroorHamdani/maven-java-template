package com.hashedin.movieRecommendation;

import java.util.ArrayList;

//1|24|M|technician|85711
public class User {
	private String UserId;
	private Integer Age;
	private String Gender;
	private String Job;
	private Integer count;
	private ArrayList<Integer> genre;
	public ArrayList<Integer> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<Integer> genre) {
		this.genre = genre;
	}
	public User() {
		count=0;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
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
		return "User [UserId=" + UserId + ", Age=" + Age + ", Gender=" + Gender
				+ ", Job=" + Job + ", count=" + count + "]";
	}
	
}
