package org.krypto.controller;

import java.util.HashMap;
import java.util.List;

import org.krypto.Services.HallService;
import org.krypto.model.Company;
import org.krypto.model.Hall;
import org.krypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/user")
public class HallController {
	@Autowired
	HallService hallService;
	

	@RequestMapping("/getAllHall")
	public List<Hall> getAllHall() {
		return hallService.getAllHall();
	}

	@RequestMapping("/dashboard")
	public List<Company> getAllCompany() {
		return hallService.getAllCompany();
	}

	@RequestMapping("/halls")
	public List<Hall> getHallByCompany(@RequestBody HashMap<String, String> request) {
		String companyId = request.get("com_id");
		return hallService.getHallByCompany(companyId);
	}

	@RequestMapping("/profile")
	public User getProfileById(@RequestParam Long id) throws Exception {
		return hallService.getProfileById(id);
	}

	@PutMapping("/editProfile")
	public User editProfile(@RequestBody User user) {
		return hallService.editProfile(user);
	}
}
