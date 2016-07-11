package lotto.store.controller;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	@JsonView(Views.Public.class)
	String username;

	String password;

	@JsonView(Views.Public.class)
	String email;

	@JsonView(Views.Public.class)
	String phone;

	String address;

	// getters, setters and contructors
}
