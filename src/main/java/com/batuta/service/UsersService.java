package com.batuta.service;

import org.springframework.stereotype.Service;

import com.batuta.model.Users;
import com.batuta.repository.UsersRepository;

@Service
public class UsersService extends ServiceDefault<Users, UsersRepository> {

}
