package com.example.demosample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demosample.model.Home;

public interface Repository extends JpaRepository <Home, Integer>{

	

}
