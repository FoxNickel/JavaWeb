package com.hdu.carrental.service;

import java.util.ArrayList;

import com.hdu.carrental.dao.MessageDao;
import com.hdu.carrental.model.Messages;

public class MessageService {
	MessageDao msgDao = new MessageDao();
	/*增加一条留言*/
	public void addMessage(Messages msg){
		msgDao.saveMessage(msg);
	}
	/*根据用户名在数据库查找留言*/
	public Messages getMessage(String username){
		return msgDao.findMessageByName(username);
	}
	/*获得所有留言*/
	public ArrayList<Messages> getAllMessages(){
		return msgDao.findAllMessages();
	}
	/*删除留言*/
	public void deleteMessage(Messages msg){
		msgDao.deleteMessage(msg);
	}
	/*修改留言*/
	public void modifyMessage(Messages msg,String oldMessage){
		msgDao.updateMessage(msg,oldMessage);
	}
}
