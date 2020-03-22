//Class to Convert frontend data (to be input) to midend data(to be store)
//and midend data to backend data (to be registered)
package com.entech.webapp.WebAppProj.converter;

import com.entech.webapp.WebAppProj.dto.DataDto;
import com.entech.webapp.WebAppProj.entity.Surveytestdb;


public class DataConverter {
	//Convert read in data to midend data stored by java
	public static Surveytestdb dtoToEntity(DataDto dataDto) {
		Surveytestdb data = new Surveytestdb();
		data.setId(dataDto.getId());
		data.setTimestamp(dataDto.getTimestamp());
		data.setName(dataDto.getName());
		data.setRole(dataDto.getRole());
		data.setEmail(dataDto.getPiclink());
		data.setProject(dataDto.getProject());
		data.setClient(dataDto.getClient());
		data.setCollege(dataDto.getCollege());
		data.setDegree(dataDto.getDegree());
		data.setFact1(dataDto.getFact1());
		data.setFact2(dataDto.getFact2());
		return data;
	}

	//Convert backend data to midend data stored by java
	public static DataDto entityToDto(Surveytestdb data) {
		DataDto dataDto = new DataDto(data.getId(), 
									data.getTimestamp(), 
									data.getName(), 
									data.getRole(),
									data.getEmail(),
									data.getProject(),
									data.getClient(),
									data.getCollege(),
									data.getDegree(),
									data.getFact1(),
									data.getFact2());

		return dataDto;
	}
}
