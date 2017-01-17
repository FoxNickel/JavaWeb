package com.hdu.carrental.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.Messages;
import com.hdu.carrental.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport implements ModelDriven<Messages>{
	Messages msg = new Messages();
	MessageService msgService = new MessageService();
	HttpSession session = ServletActionContext.getRequest().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();
	/*¡Ù—‘*/
	public String leaveMessage(){
		msgService.addMessage(msg);
		return SUCCESS;
	}
	/*≤Èø¥¡Ù—‘*/
	public String showAllMessage(){
		request.setAttribute("messages", msgService.getAllMessages());
		if(session.getAttribute("username")==null)
			return "NotLogin";
		else
			return SUCCESS;
	}
	
	public String getAllMessages(){
		request.setAttribute("messages", msgService.getAllMessages());
		return SUCCESS;
	}
	
	public String messageEdit(){
		request.setAttribute("messages", msgService.getAllMessages());
		return SUCCESS;
	}
	
	public String modifyMessage(){
		String oldMessage = request.getParameter("oldMessage");
		msgService.modifyMessage(msg,oldMessage);
		return SUCCESS;
	}
	
	public String deleteMessage(){
		msgService.deleteMessage(msg);
		return SUCCESS;
	}
	@Override
	public Messages getModel() {
		return msg;
	}
	
}
