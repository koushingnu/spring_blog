package com.example.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.blog.entity.Article;

@Mapper
public interface ArticleMapper {

	@Select("SELECT * FROM articles")
	List<Article> findAll();
	
	@Insert("INSERT INTO articles (title, content) VALUES (#{title}, #{content})")
	void insert (Article article);
	
	@Update("UPDATE articles SET title = #{title}, conten=#{content} where id = #{id}")
	void update(Article article);
	
	@Delete("DELETE FROM articles WHERE id = #{id}")
	void delete(Long id);
}
