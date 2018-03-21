package com.unicom.busi.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.unicom.busi.entity.Address;
import com.unicom.busi.entity.Person;

@WebService(
			serviceName="testService",
			endpointInterface="com.unicom.busi.ws.WsService",
			name="WsService"
		)
public class WsServiceImpl implements WsService {

	@Override
	@WebMethod(exclude=false)
	public void sayHello(String name) {
		System.out.println(name + ",你好");
	}

	@Override
	public Address getAddr() {
		return new Address("山东","济南","历城区");
	}

	@Override
	public List<Address> getAddrs() {
		List<Address> list = new ArrayList<Address>();
		list.add(new Address("山东","济南","历城区"));
		list.add(new Address("山东","济南","历下区"));
		return list;
	}

	@Override
	public Person getPerson() {
		Address addr = new Address("山东","济南","历城区");
		Person person =  new Person(1,"zhangsan",28,addr);
		return person;
	}

}
