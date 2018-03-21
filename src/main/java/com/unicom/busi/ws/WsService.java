package com.unicom.busi.ws;

import java.util.List;

import javax.jws.WebService;

import com.unicom.busi.entity.Address;
import com.unicom.busi.entity.Person;

@WebService
public interface WsService {

	void sayHello(String name);
	
	Address getAddr();
	
	List<Address> getAddrs();
	
	Person getPerson();
}
