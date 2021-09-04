package com.ssm.maven.core.service;

import com.ssm.maven.core.entity.Article;

import java.util.List;
import java.util.Map;


public interface ArticleService
{
	 List<Article> findArticle(Map<String, Object> map);

	 Long getTotalArticle(Map<String, Object> map);

	 int addArticle(Article article);

	 int updateArticle(Article article);

	 void deleteArticle(String id);

	 Article findById(String id);
}
