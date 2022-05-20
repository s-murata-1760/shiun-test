package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Category;
import com.example.demo.model.Expensis;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ExpensisRepository;
import com.example.demo.repository.SumExpensisRepository;

@Controller
public class ExpensisController {
	
	@Autowired
	SumExpensisRepository sumExpensisRepository;

	@Autowired
	ExpensisRepository expensisRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	HttpSession session;

	@RequestMapping("/expensis")
	public ModelAndView index(ModelAndView mv) {
		User user = (User) session.getAttribute("user");
		List<Object[]> total = sumExpensisRepository.selectSum(user.getUserId());
		mv.addObject("sum", total.get(0)[1]);

		List<Expensis> expensis = expensisRepository.findAll();
		for (Expensis e : expensis) {
			Category category = categoryRepository.findByCategoryId(e.getCategoryId());
			e.setCategoryName(category.getCategoryName());
		}
		List<Expensis> personalTotal = expensisRepository.userExpensis(user.getUserId());
		mv.addObject("expensis", personalTotal);

		mv.setViewName("expensis");

		return mv;
	}

	@RequestMapping("/expensis/create")
	public ModelAndView create(@RequestParam(name = "category", defaultValue = "") Integer category,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "date", defaultValue = "") String date,
			@RequestParam(name = "price", defaultValue = "") Integer price, ModelAndView mv) {
		date = date.replaceAll("-", "");
		Expensis t = new Expensis(1, name, price, date, category);

		expensisRepository.saveAndFlush(t);

		mv.setViewName("redirect:/expensis");
		return mv;
	}

	@RequestMapping(value = "/expense/{expensisId}/edit")
	public ModelAndView edit(@PathVariable(name = "expensisId") Integer expensisId, ModelAndView mv) {

		// ユーザ情報を主キーで検索
		Expensis expense = expensisRepository.findById(expensisId).get();
		List<Category> categories = categoryRepository.findAll();
		mv.addObject("expense", expense);
		mv.addObject("categories", categories);

		mv.setViewName("expenseEdit");
		return mv;
	}

	@RequestMapping("/expensis/update")
	public ModelAndView update(@RequestParam(name = "category", defaultValue = "") String category,
			@RequestParam(name = "expensisId", defaultValue = "") Integer expensisId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "date", defaultValue = "") String date,
			@RequestParam(name = "price", defaultValue = "") Integer price, ModelAndView mv) {

		date = date.replaceAll("-", "");
		Expensis expense = new Expensis(1, name, price, date, 1);

		expense.setExpensisId(expensisId);

		expensisRepository.saveAndFlush(expense);

		mv.setViewName("redirect:/expensis");

		return mv;
	}

	@RequestMapping("/expensis/delete")
	public ModelAndView delete(@RequestParam("expensis_id") Integer expensis_id, ModelAndView mv) {
		expensisRepository.deleteById(expensis_id);

		mv.setViewName("redirect:/expensis");
		return mv;
	}

}
