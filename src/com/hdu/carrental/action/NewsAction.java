package com.hdu.carrental.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.News;
import com.hdu.carrental.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsAction extends ActionSupport implements ModelDriven<News> {
	private News news=new News();
	private NewsService newsService=new NewsService();
	HttpSession session = ServletActionContext.getRequest().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();
	public String NewsInfo()
	{
		request.setAttribute("news", newsService.findAllNews());
		if(session.getAttribute("username")==(null))
			return "NotLogin";
		else
			return "success";
	}
	
	public String addNews(){
		newsService.addNews(news);
		return SUCCESS;
	}
	public String getAllNews(){
		request.setAttribute("news", newsService.findAllNews());
		return SUCCESS;
	}
	
	public String newsEdit(){
		request.setAttribute("news", newsService.findAllNews());
		return SUCCESS;
	}
	
	public String modifyNews(){
		newsService.modifyNews(news);
		return SUCCESS;
	}
	
	public String deleteNews(){
		newsService.deleteNews(news);
		return SUCCESS;
	}
	@Override
	public News getModel() {
		return news;
	}
}
