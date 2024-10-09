package com.example.demosample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demosample.dao.Repository;
import com.example.demosample.model.Home;

@Service
public class HomeService {
	
	@Autowired
	private Repository repository;

	public List<Home> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void save(Home home) {
		// TODO Auto-generated method stub
		repository.save(home);
	}

	public Optional<Home> getHomeById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	

}
