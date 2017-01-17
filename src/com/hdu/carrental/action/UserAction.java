package com.hdu.carrental.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hdu.carrental.model.User;
import com.hdu.carrental.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService userService = new UserService();
	HttpSession session = ServletActionContext.getRequest().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();
	/*�û�ע��*/
	public String register(){
		userService.addUser(user);
		return SUCCESS;
	}
	/*�û���¼*/
	public String login(){
		session.setAttribute("username", user.getUserName());//���û�������session���棬�Ա��Ժ��õ�
		request.setAttribute("password", user.getPassword());
		if(userService.loginVerify(user.getUserName(),user.getPassword()))
			return SUCCESS;
		return ERROR;
	}
	/*��õ�ǰ�˻���Ϣ����ʾ��user_profile����*/
	public String accountInfo(){
		/*�����ݿ��ȡ��ǰ�û���Ϣ*/
		User userFromDB = userService.getUser(session.getAttribute("username").toString());
		user.setUserName(session.getAttribute("username").toString());
		user.setRealName(userFromDB.getRealName());
		user.setTel(userFromDB.getTel());
		user.setEmail(userFromDB.getEmail());
		return SUCCESS;
	}
	/*�޸ĸ�����Ϣ*/
	public String modifyProfile() {
		userService.modifyProfile(user);
		return SUCCESS;
	}
	
	/*�˳�*/
	public String logOut(){
		session.invalidate();
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
