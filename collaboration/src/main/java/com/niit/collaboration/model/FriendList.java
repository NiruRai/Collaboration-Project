package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FriendList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int friendListId;
	private int fromUserId;
	private int toUserId;
	private boolean requestApproved;
	private boolean requestRejected;
	private String respondStatus;

	public int getFriendListId() {
		return friendListId;
	}

	public void setFriendListId(int friendListId) {
		this.friendListId = friendListId;
	}

	public String getRespondStatus() {
		return respondStatus;
	}

	public void setRespondStatus(String respondStatus) {
		this.respondStatus = respondStatus;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public boolean isRequestApproved() {
		return requestApproved;
	}

	public void setRequestApproved(boolean requestApproved) {
		this.requestApproved = requestApproved;
	}

	public boolean isRequestRejected() {
		return requestRejected;
	}

	public void setRequestRejected(boolean requestRejected) {
		this.requestRejected = requestRejected;
	}

		
}
