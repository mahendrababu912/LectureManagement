package com.letsstartcoding.springbootrestapiexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letsstartcoding.springbootrestapiexample.Entity.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
	public Optional<UserInfo> findByUserName(String UserName);

}
