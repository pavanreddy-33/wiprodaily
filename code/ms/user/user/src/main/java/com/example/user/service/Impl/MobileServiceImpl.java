package com.example.user.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.dto.Mobile;
import com.example.user.repo.MobileRepo;
import com.example.user.service.MobileService;


@Service
public class MobileServiceImpl implements MobileService{

	@Autowired
	MobileRepo mobileRepo;
	
	@Override
	public void postMobile(Mobile mobile) {
		mobileRepo.postMobile(mobile);
	}

	@Override
	public void deleteMobile(Mobile mobile) {
		mobileRepo.deleteMobile(mobile);
	}


	@Override
	public Mobile getMobileByName(String name) {
		return mobileRepo.getMobileByName(name);
	}

	@Override
	public void updateMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		mobileRepo.updateMobile(mobile);
	}

	@Override
	public List<Mobile> getMobile() {
		return mobileRepo.getMobile();
	}

}
