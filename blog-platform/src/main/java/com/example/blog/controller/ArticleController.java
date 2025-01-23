package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	private final ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping
	public String listArticles(Model model) {
		model.addAttribute("articles", articleService.getAllArticles());
		return "articles/list";
	}
	
	@GetMapping("/new")
	public String newArticleForm(Model model) {
		model.addAttribute("article", new Article());
		return "articles/form";
	}
	
	@PostMapping
	public String saveArticle(@ModelAttribute Article article) {
		articleService.saveArticle(article);
		return "redirect:/articles";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteArtice(@PathVariable Long id) {
		articleService.deleteArticle(id);
		return "redirect:/articles";
	}
}
