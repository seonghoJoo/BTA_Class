package com.example.onlineeduplatformuser.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository repository;

	@Override
	@Transactional
	public Mono<UserLoginResponse> loginService(Map<String, Object> param) {
		int id = Integer.parseInt(param.get("userId").toString());
		String password = param.get("password").toString();
		System.out.println("=============" + id + "    " + password);
		Mono<UserLoginResponse> results = repository.findByUserIdAndPassWord(id, password);
		return results;
	}

}