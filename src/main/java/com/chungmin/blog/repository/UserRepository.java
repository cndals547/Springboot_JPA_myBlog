package com.chungmin.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chungmin.blog.model.User;


//DAO
//자동으로 bean등록이 된다.
@Repository //생략가능.
public interface UserRepository extends JpaRepository<User, Integer>{
	//JPA Naming 쿼리
	//SELECT * FROM user WHRER username = ? and password = ?;
	//User findByUsernameAndPassword(String username, String password);
	
	//@Query(value="SELECT * FROM user WHRER username = ?1 and password = ?2", nativeQuery = true)
	//User login(String username, String password);
	
	//select * from user where username=1?;
	Optional<User> findByUsername(String username);
}
