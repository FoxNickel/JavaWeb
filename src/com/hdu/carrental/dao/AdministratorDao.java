package com.hdu.carrental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdu.carrental.model.Administrator;

public class AdministratorDao {
	public Administrator getAdministrator(){
		String sql = "select * from administrator";
		Administrator admin = new Administrator();
		DataBaseService.connectDataBase();
		ResultSet rs = DataBaseService.executeQurey(sql);
		try {
			while(rs.next()){
				admin.setUserName(rs.getString(1));
				admin.setPassWord(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataBaseService.close();
		}
		return admin;
	}
	
}
