package com.hdu.carrental.service;

import java.util.List;

import com.hdu.carrental.dao.NewsDao;
import com.hdu.carrental.model.News;

public class NewsService {
	NewsDao newsdao=new NewsDao();
	public void addNews(News news)
	{
		newsdao.savaNews(news);
	}
	public void deleteNews(News news)
	{
		newsdao.deleteNews(news);
	}
	public void modifyNews(News news)
	{
		newsdao.modifyNews(news);
	}
	public News findNewsByTitle(String title)
	{
		News news=newsdao.findNewsByTitle(title);
		return news;
	}
	public List<News> findAllNews()
	{
		List<News> list = newsdao.findAllNews();
		return list;
	}

}
