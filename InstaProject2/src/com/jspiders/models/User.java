package com.jspiders.models;

public class User 
{
	private int id;
	private String name;
	private String email;
	private Long mob;
	private String pwd;
	private String dob;
	private String gender;
	private String bio;
	
	public User()
	{
		
	}
	
	public User(String name, String email, long mob, String pwd, String dob, String gender, String bio) {
		super();
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.pwd = pwd;
		this.dob = dob;
		this.gender = gender;
		this.bio = bio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMob() {
		return mob;
	}

	public void setMob(Long mob) {
		this.mob = mob;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public int hashCode() 
	{
		return id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mob=" + mob + ", pwd=" + pwd + ", dob=" + dob
				+ ", gender=" + gender + ", bio=" + bio + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getMob()=" + getMob() + ", getPwd()=" + getPwd() + ", getDob()=" + getDob() + ", getGender()="
				+ getGender() + ", getBio()=" + getBio() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()="  + "]";
	}
	
	
	
	
}
