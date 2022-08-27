package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.HelloRepository;

@Service
public class HelloService {
	
	@Autowired
	private HelloRepository helloRepository;
	
	/** 従業員を1人取得する */
	public EmployeeEntity getEmployee(String id) {
		// 検索 findbyidでidを条件に検索している
		Map<String, Object> map = helloRepository.findById(id);
		
		// Mapから値を取得 ObjectでMapに詰まっていたので、型変換している
		String employeeId = (String) map.get("id");
		String name = (String) map.get("name");
		int age = (Integer) map.get("age");
		
		// Employeeクラスに値をセット
		EmployeeEntity employee = new EmployeeEntity();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		
		return employee;
	}
	

}
