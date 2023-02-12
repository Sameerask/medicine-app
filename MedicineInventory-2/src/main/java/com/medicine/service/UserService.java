package com.medicine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.UserDao;
import com.medicine.dto.UserDto;
import com.medicine.entity.Medicine;
import com.medicine.entity.User;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	MedicineDao medicineDao;
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao=userDao;
	}

	
	public UserService() {
		// TODO Auto-generated constructor stub
	}


	public String createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(userDto.getUsername());
		
		String pass = userDto.getPassword();
		if(checkPasswordStrength(pass)) {
			System.out.println("GOOD !");
			user.setPassword(userDto.getPassword());
			user.setStatus(true);
			userDao.save(user);
			return "User Added Successfully !";
		}else {
			return "Password should be of minimum 6 characters, 1 uppercase, 1 number and a special symbol!";
		}
		
		
	}
	
	
	
	public boolean validateUser(String username, String password) {
		User user= userDao.findByUsername(username);
		if(user != null&&user.getPassword().equals(password)&&user.isStatus()) {
			return true;
		}
		return false;
	}
	public List<Medicine> getAllMedicines() {
		return medicineDao.findAll();
		}
	public boolean checkPasswordStrength(String password) {
		boolean hasUpperCase = !password.equals(password.toLowerCase());
		boolean hasNumber = password.matches(".*\\d.*");
		boolean hasSpecialSymbol = !password.matches("[A-Za-z0-9 ]*");
		return password.length()>=6 && hasUpperCase && hasNumber && hasSpecialSymbol;
	}

}
