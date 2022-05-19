package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/")
	public String login() {
		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam String name, ModelAndView mv) {
		User user = userRepository.findByUserName(name);
		if (user == null) {
			mv.addObject("message", "ユーザが存在しません");
			mv.setViewName("index");
			return mv;
		} else {
			mv.setViewName("top");
			return mv;
		}
	}

	@RequestMapping("/newuser")
	public ModelAndView newuser(ModelAndView mv) {
		mv.setViewName("newUser");
		return mv;
	}
}