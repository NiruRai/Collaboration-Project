package com.niit.letztalkbackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Forum implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	private String forumTitle;
	private String fdescription;
	private boolean Isapproved;
	private Date forumdate;
	private String rejectionReason;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Users users;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	
	public String getFdescription() {
		return fdescription;
	}

	public void setFdescription(String fdescription) {
		this.fdescription = fdescription;
	}

	public boolean isIsapproved() {
		return Isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		Isapproved = isapproved;
	}

	public Date getForumdate() {
		return forumdate;
	}

	public void setForumdate(Date forumdate) {
		this.forumdate = forumdate;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}


}
