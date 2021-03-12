package com.chungmin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chungmin.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardSerivce;
	
	@GetMapping({"", "/"})
	public String index(Model model) {
		model.addAttribute("boards", boardSerivce.글목록());
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
