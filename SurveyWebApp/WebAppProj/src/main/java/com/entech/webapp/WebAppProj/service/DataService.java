package com.entech.webapp.WebAppProj.service;

import java.util.Collection;

import com.entech.webapp.WebAppProj.dto.DataDto;
import com.entech.webapp.WebAppProj.entity.Surveytestdb;

public interface DataService {
    DataDto getId(int id);
	void saveUser(DataDto dataDto);
	Collection<Surveytestdb> getAllUsers();
}
