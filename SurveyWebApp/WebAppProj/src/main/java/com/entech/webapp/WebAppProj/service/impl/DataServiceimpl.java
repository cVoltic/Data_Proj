package com.entech.webapp.WebAppProj.service.impl;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entech.webapp.WebAppProj.converter.DataConverter;
import com.entech.webapp.WebAppProj.dto.DataDto;
import com.entech.webapp.WebAppProj.entity.Surveytestdb;
import com.entech.webapp.WebAppProj.repository.DataRepository;
import com.entech.webapp.WebAppProj.service.DataService;

@Service
public class DataServiceimpl implements DataService{
	@Autowired
	DataRepository dataRepository;

	@Override
	public Collection<Surveytestdb> getAllUsers() {
		return dataRepository.findAll().stream().collect(Collectors.toList());
		//return dataRepository.findAll().stream().map(DataConverter::entityToDto).collect(Collectors.toList());
	}
	

	@Override
	public void saveUser(DataDto dataDto) {
		dataRepository.save(DataConverter.dtoToEntity(dataDto));
	}
	

	@Override
	public DataDto getId(int id) {
		//return DataConverter.entityToDto(dataRepository.getOne(id));
		return null;
	}





}
