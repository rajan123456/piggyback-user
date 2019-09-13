package com.incentives.piggyback.user.service;

import java.util.ArrayList;

import com.incentives.piggyback.user.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.incentives.piggyback.user.model.Users;

@Service
public class JwtUserDetailsService implements UserDetailsService {


	@Autowired
	private UserServiceRepository userServiceRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userServiceRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getUser_password(),
				new ArrayList<>());
	}

	public Users save(Users user) {
		Users newUser = new Users();
		newUser.setFirst_name(user.getFirst_name());
		newUser.setLast_name(user.getLast_name());
		newUser.setUser_interests(user.getUser_interests());
		newUser.setMobile_number(user.getMobile_number());
		newUser.setMobile_verified(user.getMobile_verified());
		newUser.setEmail(user.getEmail());
		newUser.setUser_password(bcryptEncoder.encode(user.getUser_password()));
		newUser.setUser_role(user.getUser_role());
		newUser.setUser_type(user.getUser_type());
		newUser.setDevice_id(user.getDevice_id());
		return userServiceRepo.save(newUser);
	}

	public Users updateUser(Users user) {
		Users newUser = new Users();
		newUser.setId(user.getId());
		newUser.setFirst_name(user.getFirst_name());
		newUser.setLast_name(user.getLast_name());
		newUser.setUser_interests(user.getUser_interests());
		newUser.setMobile_number(user.getMobile_number());
		newUser.setMobile_verified(user.getMobile_verified());
		newUser.setEmail(user.getEmail());
		newUser.setUser_password(bcryptEncoder.encode(user.getUser_password()));
		newUser.setUser_role(user.getUser_role());
		newUser.setUser_type(user.getUser_type());
		newUser.setDevice_id(user.getDevice_id());
		return userServiceRepo.save(newUser);
	}

}