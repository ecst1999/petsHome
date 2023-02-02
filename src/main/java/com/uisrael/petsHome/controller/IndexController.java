package com.uisrael.petsHome.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController implements Serializable {

	private static final long serialVersionUID = 1L;

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
