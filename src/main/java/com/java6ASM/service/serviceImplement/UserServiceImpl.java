package com.java6ASM.service.serviceImplement;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java6ASM.bean.SessionService;
import com.java6ASM.model.User;
import com.java6ASM.repository.UserRepository;
import com.java6ASM.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SessionService  sessionService;
	
	@Override
	public User findById(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByIdAndPassword(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	@Override
	public Page<User> findUserByKeyWord( Optional<String> key,Optional<Integer> p) {
		String keyword = key.orElse(sessionService.get("keywords", ""));
		sessionService.set("keywords", keyword);
		Pageable pageable  = PageRequest.of(p.orElse(0), 8);
		return userRepository.findUserByKeyWord("%"+keyword+"%",pageable);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findIdUserById(String idUser) {
		return userRepository.findIdUserById(idUser);
	}

	@Override
	public User findByUserForgotPass(String idUser) {
		return userRepository.findByUserForgotPass(idUser);
	}

	@Override
	public User findUserByToken(String token) {
		return userRepository.findUserByToken(token);
	}

	@Override
	public void saveResetPassword(String token, String password) {
		User user = userRepository.findUserByToken(token);
		user.setPassword(password);
		user.setActive(false);
		userRepository.save(user);
	}

	@Override
	public User findUserByOrderId(long id) {
		return userRepository.findUserByOrderId(id);
	}

}
