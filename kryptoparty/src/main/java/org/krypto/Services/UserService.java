package org.krypto.Services;


import org.krypto.model.User;
import org.krypto.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;




public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
