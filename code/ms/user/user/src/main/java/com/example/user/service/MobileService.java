package com.example.user.service;

import java.util.List;

import com.example.user.dto.Mobile;

public interface MobileService {
	
	void postMobile(Mobile mobile);
	void deleteMobile(Mobile mobile);
	Mobile getMobileByName(String name);
	public void updateMobile(Mobile mobile);
	List<Mobile> getMobile();
}
