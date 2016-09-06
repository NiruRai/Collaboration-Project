package com.niit.collaboration.model;

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
public class ForumComment implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fCommentId;
	private String fcomment;
	private int upVote;
	private int downVote;
	private int forumLike;
	private Date commentdate;
	
	@ManyToOne
	@JoinColumn(name = "forumId")
    @JsonIgnore
    private Forum forum;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Users user;

	public int getfCommentId() {
		return fCommentId;
	}

	public void setfCommentId(int fCommentId) {
		this.fCommentId = fCommentId;
	}

	

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}

	
	
		public String getFcomment() {
		return fcomment;
	}

	public void setFcomment(String fcomment) {
		this.fcomment = fcomment;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

		public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users user) {
		this.user = user;
	}

	public int getForumLike() {
		return forumLike;
	}

	public void setForumLike(int forumLike) {
		this.forumLike = forumLike;
	}
	
	
	
}
