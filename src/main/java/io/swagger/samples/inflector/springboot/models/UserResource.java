package io.swagger.samples.inflector.springboot.models;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserResource implements Resource {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private User user;

	@Override
	public List<Link> getLinks() {
		return Collections.emptyList();
	}

	public String getSurname() {

		return user.getSurName();
	}
	public String getGivenName() {
		return user.getGivenName();
	}

	//  public void getUser(){
	//	  String query = "select Name from UserDetails";
	//	 // List<Map> rows = (List<Map>)jdbcTemplate.queryForList(query);
	//	  for (Map row : rows) {
	//			user = new User();
	//			String name = (String)row.get("Name");
	//			user.setGivenName(name.split(",")[1].trim());
	//			user.setSurName(name.split(",")[0].trim());
	//			user.setDob((String)row.get("dob"));
	//		}
	//	    
	//  }
	public String getDoB() {
		String query = "select dob from UserDetails";
		String dob = jdbcTemplate.queryForObject(query,String.class);
		user.setDob(dob);
		return user.getDob();
	}

	public void getName(){
		String query = "select Name from UserDetails";
		String name = jdbcTemplate.queryForObject(query,String.class);
		user = new User();
		user.setGivenName(name.split(",")[1].trim());
		user.setSurName(name.split(",")[0].trim());

	}

}


