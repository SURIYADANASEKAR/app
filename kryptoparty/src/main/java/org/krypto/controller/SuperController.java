package org.krypto.controller;

import org.krypto.Exception.ResourceNotFoundException;
import org.krypto.Repository.CompanyRepository;
import org.krypto.Repository.UserRepository;
import org.krypto.model.Company;
import org.krypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/super")
public class SuperController {
	
	@Autowired
	UserRepository userRepo;

	
	@Autowired
	CompanyRepository adminRepo;
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<HttpStatus> deleteUser(@RequestParam Long userId){
		
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User doesnt exists with id"+userId));
		userRepo.delete(user);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
	}
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<HttpStatus> deleteAdmin(@RequestParam long id){
		
		Company company = adminRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Admin doesnt exists with id"+id));
		adminRepo.delete(company);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
	}

}