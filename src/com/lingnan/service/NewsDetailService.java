package com.lingnan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingnan.dao.NewsDetailDao;
import com.lingnan.entity.NewsDetail;

public interface NewsDetailService {
	
	public List<NewsDetail> loadNewsDetail();
	
	public List<NewsDetail> loadNewsByTitle(String title);
	
	public void deleteNews(int newsId);
}
