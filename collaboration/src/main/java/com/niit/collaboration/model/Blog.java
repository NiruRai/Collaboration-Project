package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Blog implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogId;
	private String blogTitle;
	private String blogdescription;
	private Date blogdate;
	private String rejectReason;
	private boolean Isapproved;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Users userS;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	

	
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public boolean isIsapproved() {
		return Isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		Isapproved = isapproved;
	}

	public Users getUsers() {
		return userS;
	}

	public void setUsers(Users userS) {
		this.userS = userS;
	}

	

	public Users getUserS() {
		return userS;
	}

	public void setUserS(Users userS) {
		this.userS = userS;
	}

	public String getBlogdescription() {
		return blogdescription;
	}

	public void setBlogdescription(String blogdescription) {
		this.blogdescription = blogdescription;
	}

	public Date getBlogdate() {
		return blogdate;
	}

	public void setBlogdate(Date blogdate) {
		this.blogdate = blogdate;
	}
	
	
	

}
