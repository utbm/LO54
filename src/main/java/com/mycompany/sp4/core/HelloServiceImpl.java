package com.mycompany.sp4.core;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HelloServiceImpl implements HelloService {

	private final HelloRepository repository;

	public HelloServiceImpl(HelloRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public List<HelloEntity> findAll() {
		return repository.findAll();
	}
}
