package com.hdu.carrental.service;

import java.util.ArrayList;

import com.hdu.carrental.dao.ChargesDao;
import com.hdu.carrental.model.Charges;

public class ChargesService {
	ChargesDao chargrDao = new ChargesDao();

	public void addCharge(Charges ch) {
		chargrDao.insertCharges(ch);
	}

	public void deleteCharge(Charges ch) {
		chargrDao.deleteCharges(ch);
	}

	public Charges findByusn(String usn) {
		return chargrDao.findByusn(usn);
	}
	public Charges findCharges(String usn,String carid) {
		return chargrDao.findCharges(usn,carid);
	}
	public ArrayList<Charges> findAllCharges() {
		return (ArrayList<Charges>) chargrDao.findAllCharges();
	}
	public void UpdateCharges(Charges ch)
	{
		chargrDao.updateCharges(ch);
	}
}
