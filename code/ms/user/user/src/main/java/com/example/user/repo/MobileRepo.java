package com.example.user.repo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.example.user.dto.Mobile;

@Repository
public class MobileRepo {
	
	List<Mobile> mobileList=new CopyOnWriteArrayList<>();
	
	
	public void postMobile(Mobile mobile) {
		mobileList.add(mobile);
	}
	
	public List<Mobile> getMobile() {
		return mobileList;
	}
	
	public Mobile getMobileByName(String name){
		Optional<Mobile> mobile = mobileList.stream().filter(m->m.getModelNumber().equalsIgnoreCase(name)).findFirst();
		if(mobile.isEmpty()) {
			return null;
		}else {
			return mobile.get();
		}
	}
	
	public void deleteMobile(Mobile mobile) {
		for(Mobile m:mobileList) {
			if(m.getId()==mobile.getId()) {
				mobileList.remove(mobile);
			}
		}
	}
	
	public void updateMobile(Mobile mobile) {
		int i=0;
		for(Mobile m:mobileList) {
			if(m.getId()==mobile.getId()) {
				mobileList.set(i,mobile);
			}
			i++;
		}
	}
	
}
