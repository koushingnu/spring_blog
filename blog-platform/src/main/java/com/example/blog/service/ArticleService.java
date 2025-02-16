package com.example.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.entity.Article;
import com.example.blog.mapper.ArticleMapper;

@Service
@Transactional
public class ArticleService {
	private final ArticleMapper articleMapper;
	
	public ArticleService(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	public List<Article> getAllArticles(){
		return articleMapper.findAll();
	}
	
	public void saveArticle(Article article) {
		if(article.getId() == null) {
			articleMapper.insert(article);
		}else {
			articleMapper.update(article);
		}
	}
	
	public void deleteArticle(Long id) {
		articleMapper.delete(id);
	}
}
