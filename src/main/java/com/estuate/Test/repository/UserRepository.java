package com.estuate.Test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estuate.Test.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	List<Users> findByGender(String gender);

}
