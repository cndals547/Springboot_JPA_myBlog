package com.chungmin.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chungmin.blog.model.User;
import com.chungmin.blog.repository.UserRepository;

@Service
public class PrincipalService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	//스프링이 로그인 요청을 가로챌 때, username, apssword 변수 2개를 가로채는데
	//password 부분 처리는 알아서함.
	//username이 DB에 있는지만 확인해서 return
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용차를 찾을 수 없습니다. : " + username);
				});
		return new PrincipalDetail(principal); //Security의 세션에 유저 정보가 저장이 됨.
	}
}
