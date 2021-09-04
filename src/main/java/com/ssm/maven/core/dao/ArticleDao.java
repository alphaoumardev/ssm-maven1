package com.ssm.maven.core.dao;

import com.ssm.maven.core.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleDao
{
	 List<Article> findArticles(Map<String, Object> map);

	 Long getTotalArticles(Map<String, Object> map);

	 int insertArticle(Article article);

	 int updArticle(Article article);

	 int delArticle(String id);

	 Article getArticleById(String id);

}
