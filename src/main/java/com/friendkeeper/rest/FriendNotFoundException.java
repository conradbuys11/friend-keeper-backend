package com.friendkeeper.rest;

public class FriendNotFoundException extends RuntimeException {

	public FriendNotFoundException() {
		super();
	}

	public FriendNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FriendNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FriendNotFoundException(String message) {
		super(message);
	}

	public FriendNotFoundException(Throwable cause) {
		super(cause);
	}

}
