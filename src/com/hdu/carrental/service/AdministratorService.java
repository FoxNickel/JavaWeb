package com.hdu.carrental.service;

import com.hdu.carrental.dao.AdministratorDao;
import com.hdu.carrental.model.Administrator;

public class AdministratorService {
	AdministratorDao ad = new AdministratorDao();
	public Boolean loginVerify(String username,String password){
		Administrator admin =  ad.getAdministrator();
		if(username.equals(admin.getUserName())&&password.equals(admin.getPassWord()))
			return true;
		return false;
	}
}
