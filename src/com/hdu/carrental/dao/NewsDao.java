package com.hdu.carrental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hdu.carrental.model.News;

public class NewsDao {
	public void savaNews(News news)
	{
		String sql="insert into NEWS values('"+news.getId()+"','"+news.getTitle()+"','"+news.getContent()+"')";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public void deleteNews(News news)
	{
		String sql="delete from news where id ='"+news.getId()+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public void modifyNews(News news)
	{
		String sql="update news set title = '"+news.getTitle()+"',[content] ='"+news.getContent()+"' where id = '"+news.getId()+"'";
		DataBaseService.connectDataBase();
		DataBaseService.executeUpdate(sql);
		DataBaseService.close();
	}
	public News findNewsByTitle(String title)
	{
		News news=new News();
		news.setTitle(title);
		String sql ="SELECT [CONTENT] FROM NEWS WHERE TITLE='"+title+"'";
		DataBaseService.connectDataBase();
		ResultSet rs=DataBaseService.executeQurey(sql);		
		try {
			rs.next();
			news.setContent(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataBaseService.close();
		return news;
		
	}
	public List<News> findAllNews()
	{
		String sql="select * from News";
		List<News> list = new ArrayList<News>();
		DataBaseService.connectDataBase();
		ResultSet rs=DataBaseService.executeQurey(sql);
		try {
			while(rs.next())
			{
				News news= new News();
				news.setId(rs.getString(1));
				news.setTitle(rs.getString(2));
				news.setContent(rs.getString(3));
				list.add(news);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
 
}
