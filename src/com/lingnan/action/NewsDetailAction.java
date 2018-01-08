package com.lingnan.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lingnan.entity.NewsDetail;
import com.lingnan.service.NewsDetailService;

public class NewsDetailAction extends BaseAction{
	
	@Autowired
	private NewsDetailService service;
	
	private List<NewsDetail> news;
	private String title;
	private Integer id;
	
	public String loadNews(){
		this.news = this.service.loadNewsDetail();
		System.out.println(this.news.size());
		return SUCCESS;
	}
	
	public String loadNewsByTitle(){
		this.news = this.service.loadNewsByTitle(title);
		return SUCCESS;
	}
	/**
	 * É¾³ýÐÂÎÅ
	 * @return
	 */
	public String deleteNews(){
		this.service.deleteNews(id);
		return SUCCESS;
	}
	public NewsDetailService getService() {
		return service;
	}


	public void setService(NewsDetailService service) {
		this.service = service;
	}


	public List<NewsDetail> getNews() {
		return news;
	}


	public void setNews(List<NewsDetail> news) {
		this.news = news;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
