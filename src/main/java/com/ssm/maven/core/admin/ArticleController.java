package com.ssm.maven.core.admin;

import com.alibaba.fastjson.JSONObject;
import com.ssm.maven.core.entity.Article;
import com.ssm.maven.core.entity.PageBean;
import com.ssm.maven.core.service.ArticleService;
import com.ssm.maven.core.util.DateUtil;
import com.ssm.maven.core.util.ResponseUtil;
import com.ssm.maven.core.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jfunc.json.impl.JSONArray;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private ArticleService articleService;
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ArticleController.class);// 日志文件


	@RequestMapping("/list")
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			Article article, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
		}
		if (article != null) {
			map.put("articleTitle",
					StringUtil.formatLike(article.getArticleTitle()));
		}
		List<Article> articleList = articleService.findArticle(map);
		Long total = articleService.getTotalArticle(map);
		JSONObject result = new JSONObject();
		result.put("rows", articleList);
		result.put("total", total);
		ResponseUtil.write(response, result);
		log.info("request: article/list , map: " + map.toString());
		return null;
	}


	@RequestMapping("/save")
	public String save(Article article, HttpServletResponse response)
			throws Exception {
		int resultTotal = 0;
		if (article.getId() == null) {
			article.setArticleCreateDate(DateUtil.getCurrentDateStr());
			resultTotal = articleService.addArticle(article);
		} else {
			resultTotal = articleService.updateArticle(article);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		log.info("request: article/save , " + article.toString());
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			articleService.deleteArticle(idsStr[i]);
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		log.info("request: article/delete , ids: " + ids);
		return null;
	}


	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id") String id,
			HttpServletResponse response) throws Exception {
		Article article = articleService.findById(id);
		ResponseUtil.write(response, article);
		log.info("request: article/findById");
		return null;
	}
}