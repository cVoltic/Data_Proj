//Spring Controller to handel some REST calls from user ends

package com.entech.webapp.WebAppProj.controller;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entech.webapp.WebAppProj.entity.Surveytestdb;
import com.entech.webapp.WebAppProj.repository.DataRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping(path="/views/demo")
//Enable CrossOrigin Talk to clientside
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {
	
	@Autowired
	DataRepository dataRepository;
	

	//Get all data from database
	@GetMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Surveytestdb> getAllUsers() {
		return dataRepository.findAll().stream().collect(Collectors.toList());
	}

	//Save data from user generated field
	//Enable Save to for only 10 minutes
	@CrossOrigin(maxAge=600)
	@PostMapping(path="/add",consumes="application/json")
	public String addNewUser(@RequestBody Surveytestdb body){
		
		//Get Stuff from JSON Input
        String name = body.getName();
        String email = body.getEmail();
        String college = body.getCollege();
        String degree = body.getDegree();
        String role = body.getRole();
        String project = body.getProject();
        String client = body.getClient();
        String fact1 = body.getFact1();
        String fact2 = body.getFact2();
        //String picLink = body.getPicLink();

        //Auto time stamp generator
		Surveytestdb sdb = new Surveytestdb();
		Date date = new Date();
		Timestamp tf = new Timestamp(date.getTime());
		String timestamp = tf.toString();
		
        //Append Stuff to DB
		sdb.setTimestamp(timestamp);
        sdb.setName(name);
        sdb.setEmail(email);
        sdb.setCollege(college);
        sdb.setDegree(degree);
        sdb.setRole(role);
        sdb.setProject(project);
        sdb.setClient(client);
        sdb.setFact1(fact1);
        sdb.setFact2(fact2);
        //sdb.setPicLink(picLink);

        dataRepository.save(sdb);
        
        return "Saved to DB";
    }
	
	//Update User by id
	@PatchMapping(path="/all/{id}",consumes="application/json")
	public String updateUser(@RequestBody Surveytestdb update){
		
        int userID = update.getId();
        
        Surveytestdb userFromDb = new Surveytestdb();
        userFromDb = dataRepository.getOne(userID);
        
        userFromDb.setName(update.getName());
        userFromDb.setEmail(update.getEmail());
        userFromDb.setCollege(update.getCollege());
        userFromDb.setDegree(update.getDegree());
        userFromDb.setRole(update.getRole());
        userFromDb.setProject(update.getProject());
        userFromDb.setClient(update.getClient());
        userFromDb.setFact1(update.getFact1());
        userFromDb.setFact2(update.getFact2());
        
        dataRepository.save(userFromDb);

        return "Updated User to DB";
    }
	

	@DeleteMapping(path="/all/{id}")
    public String delete(@PathVariable int id){	
		//java.util.Optional<Surveytestdb> user = dataRepository.findById(id);

        dataRepository.deleteById(id);
        return String.format("Sucessfully Removed UserID: %d", id);
    }
	
	
	//Get data from table by id
	//@GetMapping("/surveytestdb/all")
    //public Surveytestdb show(@PathVariable String id){
    //    int tableId = Integer.parseInt(id);
    //    return dataRepository.findOne(tableId);
    //}
	
	//
	//Get data from table by id
	/*@GetMapping(path="/all")
    public Surveytestdb show(@PathVariable String id){
        int tableId = Integer.parseInt(id);
        return dataRepository.findById(tableId);
    }*/
	/*
	 * @Autowired
	DataService dataService;
	
	 * @RequestMapping(Constants.GET_ALL_USERS)
	public Collection<Surveytestdb> getAllUsers() {
		return dataService.getAllUsers();
	}da
	 * 
	 * @RequestMapping(value= Constants.SAVE_USER, method= RequestMethod.POST)
	public void saveUser(@RequestBody DataDto dataDto) {
	dataService.saveUser(dataDto);
	}
	@PostMapping(path="/add")
	public Surveytestdb create(@RequestBody Map<String, String> body){
		//int id = Integer.parseInt(body.get("id"));
        String timestamp = body.get("timestamp");
        String name = body.get("name");
        String role = body.get("role");
        String piclink = body.get("piclink");
        String project = body.get("project");
        String client = body.get("client");
        String college = body.get("college");
        String degree = body.get("degree");
        String fact1 = body.get("fact1");
        String fact2 = body.get("fact2");
        return dataRepository.save(new Surveytestdb(timestamp, name, role, piclink, project, client, college, degree, fact1, fact2));
    }
    
    @PostMapping(path="/add",consumes="application/json")
	public @ResponseBody String addUser(@RequestParam String name,
										@RequestParam String email, 
										@RequestParam String college, 
										@RequestParam String degree,
										@RequestParam(required=false) String role ,
										@RequestParam(required=false) String project, 
										@RequestParam(required=false) String client, 
										@RequestParam String fact1, 
										@RequestParam String fact2){
		
        sdb.setName(name);
        sdb.setEmail(email);
        sdb.setCollege(college);
        sdb.setDegree(degree);
        sdb.setRole(role);
        sdb.setProject(project);
        sdb.setClient(client);
        sdb.setFact1(fact1);
        sdb.setFact2(fact2);
        dataRepository.save(sdb);
        return "Saved to DB";
    }
    */
}
