package com.entech.webapp.WebAppProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.entech.webapp.WebAppProj.entity.Surveytestdb;

//Enable Cross Origin talk
@CrossOrigin(origins = "http://localhost:4200")
public interface DataRepository extends JpaRepository<Surveytestdb, Integer> {

}
