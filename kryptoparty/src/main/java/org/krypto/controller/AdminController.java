package org.krypto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.krypto.Exception.ResourceNotFoundException;
import org.krypto.Repository.CompanyRepository;
import org.krypto.Repository.HallRepository;
import org.krypto.Repository.UserRepository;
import org.krypto.Services.HallService;
import org.krypto.model.Company;
import org.krypto.model.Hall;
import org.krypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@ResponseBody
public class AdminController {

    @Autowired
    HallRepository hallRepo;

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    HallService hallService;

    @PostMapping("/addCompany")
    public Company createCompany(@RequestBody Company company){
        return companyRepo.save(company);
    }

    @GetMapping("/getCompanyByUserId")
    public Optional<Company> getCompanyByUserId(@RequestParam Long userId){
        return companyRepo.findById(userId);
    }

    @GetMapping ("/dashboard")
    public List<Hall> getHallByCompany(@RequestBody HashMap<String, String> request) {
        String company_id = request.get("com_id");
        return hallService.getHallByCompany(company_id);
    }

    @PostMapping("/addHall")
    public Hall createhall(@RequestBody Hall hall) {
        return hallRepo.save(hall);
    }

    @PutMapping("/editHall")
    public ResponseEntity<Hall> updateHall(@RequestParam long id, @RequestBody Hall hall) {
        Hall updateHall = hallRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall doesnt exixts with id" + id));

        updateHall.setEventdate(hall.getEventdate());
        updateHall.setDescription(hall.getDescription());
        updateHall.setHalltype(hall.getHalltype());
        updateHall.setHallprice(hall.getHallprice());
        hallRepo.save(updateHall);

        return ResponseEntity.ok(updateHall);

    }

    @DeleteMapping("/deleteHall")
    public ResponseEntity<HttpStatus> deleteHall(@RequestParam long id) {

        Hall hall = hallRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall doesnt exists with id" + id));

        hallRepo.delete(hall);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping("/profile")
    public Optional<User> getProfileById(@RequestParam long id) {
        return userRepo.findById(id);
    }

    @PutMapping("/editProfile")
    public ResponseEntity<Company> editProfile(@RequestParam long id, @RequestBody Company company) {
        Company editProfile = companyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile doesnt exists with id" + id));

        editProfile.setCompanyname(company.getCompanyname());
        editProfile.setCompanyaddress(company.getCompanyaddress());
        editProfile.setMobilenumber(company.getMobilenumber());

        companyRepo.save(editProfile);

        return ResponseEntity.ok(editProfile);

    }

}

