package org.krypto.Services;

import java.util.List;

import org.krypto.Repository.CompanyRepository;
import org.krypto.Repository.HallRepository;
import org.krypto.Repository.UserRepository;
import org.krypto.model.Company;
import org.krypto.model.Hall;
import org.krypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HallService {

	@Autowired
	HallRepository hallRepo;
	@Autowired
	CompanyRepository companyRepo;
	@Autowired
	UserRepository userRepo;

	public List<Hall> getAllHall() {
		return hallRepo.findAll();
	}

	public List<Hall> getHallByCompany(String hall_id) {
		return hallRepo.getByCompanyId(hall_id);
	}

	public List<Company> getAllCompany() {
		return companyRepo.findAll();
	}

	public Hall getHallById(long hallId) throws Exception {
		return hallRepo.findById(hallId).orElseThrow(() -> new Exception("Product is not found"));
	}

	public User getProfileById(Long id) throws Exception {
		return userRepo.findById(id).orElseThrow(() -> new Exception("profile not found"));
	}

	public User editProfile(User user) {
		return userRepo.save(user);
	}

}
