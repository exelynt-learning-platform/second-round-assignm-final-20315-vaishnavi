package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Reposotory.UserRepository;
import com.example.demo.Service.UserService;

public class UserDao{
	
	@Autowired
	 UserRepository repo;

}
