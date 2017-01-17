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
	/*用户注册*/
	public String register(){
		userService.addUser(user);
		return SUCCESS;
	}
	/*用户登录*/
	public String login(){
		session.setAttribute("username", user.getUserName());//将用户名存在session里面，以便以后用到
		request.setAttribute("password", user.getPassword());
		if(userService.loginVerify(user.getUserName(),user.getPassword()))
			return SUCCESS;
		return ERROR;
	}
	/*获得当前账户信息，显示在user_profile界面*/
	public String accountInfo(){
		/*从数据库获取当前用户信息*/
		User userFromDB = userService.getUser(session.getAttribute("username").toString());
		user.setUserName(session.getAttribute("username").toString());
		user.setRealName(userFromDB.getRealName());
		user.setTel(userFromDB.getTel());
		user.setEmail(userFromDB.getEmail());
		return SUCCESS;
	}
	/*修改个人信息*/
	public String modifyProfile() {
		userService.modifyProfile(user);
		return SUCCESS;
	}
	
	/*退出*/
	public String logOut(){
		session.invalidate();
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
