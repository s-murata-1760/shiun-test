package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Expensis;
import com.example.demo.repository.ExpensisRepository;

@Controller
public class ExpensisController {
	
	@Autowired
	ExpensisRepository expensisRepository;
	
	@RequestMapping("/expensis")
	public ModelAndView index(ModelAndView mv) {
		
		List<Expensis> expensis = expensisRepository.findAll();
		
		mv.addObject("expensis",  expensis);	
		mv.setViewName("expensis");
		
		return mv;
	}
	
	@RequestMapping("/expensis/create")
	public ModelAndView create(
			@RequestParam(name="category" , defaultValue = "") String category,
			@RequestParam(name="name", defaultValue = "") String name,
			@RequestParam(name="date", defaultValue = "") String date,
			@RequestParam(name="price", defaultValue = "") Integer price,
			ModelAndView mv) {
		
		Expensis t = new Expensis(99,1,name, price, date,1);

		expensisRepository.saveAndFlush(t);
        
		mv.setViewName("expensis");
		return mv;
	}
	
	@RequestMapping("/expensis/update")
	public ModelAndView update(
			@RequestParam("name") String name,
			@RequestParam("price") String price,
			ModelAndView mv) {
		mv.setViewName("expensis");
		return mv;
		
	}
	
	@RequestMapping("/expensis/delete")
	public ModelAndView delete(
			@RequestParam("name") String name,
			@RequestParam("price") String price,
			ModelAndView mv) {
		mv.setViewName("expensis");
		return mv;
		
	}

}
