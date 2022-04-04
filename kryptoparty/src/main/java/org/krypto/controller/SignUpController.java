package org.krypto.controller;

import org.krypto.Services.UserService;
import org.krypto.dto.UserRegistrationDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class SignUpController {

	private UserService userService;

	public SignUpController(UserService userService) {
		this.userService = userService;
	}
	
//	@ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto() {
//        return new UserRegistrationDto();
//    }
	
	
	@PostMapping("/signUp")
	public String registerUserAccount(@RequestBody UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/login";
	}

//	@GetMapping("/getSample")
//	public String getSample(){
//		return "Hello";
//	}
}