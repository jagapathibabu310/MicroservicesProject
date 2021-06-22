package com.ms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.Entity.User;
import com.ms.Repository.UserRepository;
import com.ms.ValueObject.Department;
import com.ms.ValueObject.ResponseTemplateVO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserwithDepartment(Long userId) {
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT/departments/" + user.getDepartmentId(), 
						Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
		
	}
}
