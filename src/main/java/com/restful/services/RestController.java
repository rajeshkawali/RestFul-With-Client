package com.restful.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restful.dao.RestDao;
import com.restful.model.RestModel;

@Path("/restpath")
public class RestController {

	private RestDao restdao = new RestDao();
	
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String getAllUserText() {
		System.out.println("-------|getAllUserText|-------");
		// http://localhost:8080/RestFul/webapi/restpath/text
		return "RestFul web Service";
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String addUserText(RestModel restmodel) {
		System.out.println("-------|addUserText|-------");
		// http://localhost:8080/RestFul/webapi/restpath/text
		return "POST method Test";
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<RestModel> getAllUser() {
		System.out.println("-------|getAllUser|-------");
		// Getting all users
		// http://localhost:8080/RestFul/webapi/restpath
		return restdao.getAllUser();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestModel addUser(RestModel restmodel) {
		System.out.println("-------|addUser|-------");
		// Posting User to DB.
		// http://localhost:8080/RestFul/webapi/restpath
		RestModel adduser = restdao.addUser(restmodel);
		return adduser;
	}
	
	@PUT
	@Path("/{userId}")
	public RestModel updateUser(@PathParam("userId") long id, RestModel restmodel) {
		System.out.println("-------|updateUser|-------");
		// Updating the user if id is present
		// http://localhost:8080/RestFul/webapi/restpath/2
		restmodel.setId(id);
		RestModel adduser = restdao.updateUser(restmodel);
		return adduser;
	}
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") long id) {
		System.out.println("-------|deleteUser|-------");
		// Deleting the user by given id.
		// http://localhost:8080/RestFul/webapi/restpath/2
		restdao.deleteUser(id);
	}
	
	@GET
	@Path("/{userId}")
	public RestModel getUser(@PathParam("userId") long userId) {
		System.out.println("-------|getUser|-------");
		// Getting the single user by given Id.
		// http://localhost:8080/RestFul/webapi/restpath/3
		RestModel adduser = restdao.getUser(userId);
		return adduser;
	}
	
	public RestDao getRestdao() {
		return restdao;
	}

	public void setRestdao(RestDao restdao) {
		this.restdao = restdao;
	}
}
