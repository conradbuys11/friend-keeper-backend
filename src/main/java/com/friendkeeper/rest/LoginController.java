package com.friendkeeper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	@Autowired BCryptPasswordEncoder passEncoder;
}
