package com.library.models;

public class Admin extends User {

	private static final String PASSWORD = "admin@123";

	public Admin(String userName, String userId) {
		super(userName, userId);
	}

	public static boolean authenticate(String password) {
		return PASSWORD.equals(password);
	}
}
