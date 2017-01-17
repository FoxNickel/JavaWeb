package com.hdu.carrental.service;

import java.util.ArrayList;

import com.hdu.carrental.dao.MessageDao;
import com.hdu.carrental.model.Messages;

public class MessageService {
	MessageDao msgDao = new MessageDao();
	/*����һ������*/
	public void addMessage(Messages msg){
		msgDao.saveMessage(msg);
	}
	/*�����û��������ݿ��������*/
	public Messages getMessage(String username){
		return msgDao.findMessageByName(username);
	}
	/*�����������*/
	public ArrayList<Messages> getAllMessages(){
		return msgDao.findAllMessages();
	}
	/*ɾ������*/
	public void deleteMessage(Messages msg){
		msgDao.deleteMessage(msg);
	}
	/*�޸�����*/
	public void modifyMessage(Messages msg,String oldMessage){
		msgDao.updateMessage(msg,oldMessage);
	}
}
