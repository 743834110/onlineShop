package com.lingnan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingnan.dao.NewsDetailDao;
import com.lingnan.entity.NewsDetail;
import com.lingnan.service.NewsDetailService;

@Transactional
@Service
public class NewsDetailServiceImpl implements NewsDetailService {
	
	@Autowired
	private NewsDetailDao detail;

	/**
	 * 读取新闻列表
	 */
	@Override
	public List<NewsDetail> loadNewsDetail() {
		return (List<NewsDetail>) this.detail.getListByHQL("from NewsDetail");
	}

	/**
	 * 根据新闻标题读取有关新闻列表
	 * 
	 * @author Administrator
	 * @param  title 新闻标题
	 * @return List<NewsDetail>
	 */
	public List<NewsDetail> loadNewsByTitle(String title) {
		return this.detail.getListByHQL("from NewsDetail where title like ?"
				, "%" + title + "%");
	}
	
	public void deleteNews(int newsId){
		NewsDetail news = this.detail.findById(newsId);
		this.detail.delete(news);
	}
	
}
