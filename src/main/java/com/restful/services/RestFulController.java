package com.restful.services;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.restful.bean.ParamBeanClass;
import com.restful.dao.RestDao;
import com.restful.exceptions.ThrowExceptionMessage;
import com.restful.model.RestModel;

@Path("/restfulpath")
public class RestFulController {
	
	private RestDao restdao = new RestDao();
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserPathInfo(RestModel restmodel) {
		System.out.println("-------|getUserPathInfo|-------");
		return "POST method Test";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUserWithResponse(RestModel restmodel, @Context UriInfo uriInfo) {
		System.out.println("-------|addUserWithResponse|-------");
		// responding a status code to the client with path.
		// http://localhost:8080/RestFul/webapi/restfulpath
		RestModel adduser = restdao.addUser(restmodel);
		String newId = String.valueOf(adduser.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		System.out.println("URI = "+uri);
		return Response.created(uri)
				.entity(adduser)
				.build();
		
	}
	
	@GET
	@Path("/{userId}")
	public RestModel getUserException(@PathParam("userId") long userId) {
		// Testing the Customized Exception
		// http://localhost:8080/RestFul/webapi/restfulpath/7
		System.out.println("-------|getUserException|-------");
		RestModel restmodel = new RestModel();
		long id = restmodel.getId();
		if(id != userId){
			throw new ThrowExceptionMessage("Exception : id = " + userId + " not found");
		}
		RestModel adduser = restdao.getUser(userId);
		return adduser;
	}
	
	@GET
	@Path("/querytest")
	public String getUserPath(@QueryParam("start") String start,@QueryParam("end") String end) {
		// @QueryParam (which is divided by ? ) which is used to accept the values from URI ,shown below
		// http://localhost:8080/RestFul/webapi/restfulpath/querytest?start=2017&end=2020
		System.out.println("-------|getUserPath|-------");
		String values = "year="+start+"\nend="+end;
		return values;
	}
	
	@GET
	@Path("/paramtest")
	public String getUserPath(@MatrixParam("year") String year,
							  @CookieParam("name") String name,
							  @HeaderParam("customHeader") String customHeader) {
		// MatrixParam (which is divided by ; )which accepts the values from URI in to RestFull WS.
		// http://localhost:8080/RestFul/webapi/restfulpath/paramtest;year=2017
		System.out.println("-------|getUserPath|-------");
		String values = "year="+year+"\nCookie="+name+"\nHeader value="+customHeader;
		return values;	
	}
	
	@GET
	@Path("/contexttest")
	public String getUserContextPath(@Context UriInfo uriinfo,@Context HttpHeaders httpheader) {
		// @Context which provides all the path info...
		// http://localhost:8080/RestFul/webapi/restfulpath/contexttest
		System.out.println("-------|getUserContextPath|-------");
		String values = "Path :"+uriinfo.getAbsolutePath();
		values +="\nCookie Value :"+httpheader.getCookies().toString();
		return values;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/formpath")
	public String FormPostTest(@FormParam("firstName") String firstName, 
						@FormParam("lastName") String lastName,
						@Context Response response) throws IOException {
		System.out.println("-------|FormPostTest|-------");
		// Getting Form fields values in to RestFul WS.
		// http://localhost:8080/RestFul/webapi/restfulpath/formpath
		System.out.println("-------|First Name|-------"+firstName);
		System.out.println("-------|Last Name|-------"+lastName);
		return "First name="+firstName+"\n Last name="+lastName;
	}
	
	@GET
	@Path("/beanparam")
	public String getBeanAnnotation(@BeanParam ParamBeanClass pbc) {
		// ParamBeanClass class contains all annotations and used them by @BeanParam
		// http://localhost:8080/RestFul/webapi/restfulpath/beanparam?valueA=10&valueB=20&valueC=30
		System.out.println("-------|getBeanAnnotation|-------");
		System.out.println("-------|getValueA|-------"+pbc.getValueA());
		System.out.println("-------|getValueB|-------"+pbc.getValueB());
		System.out.println("-------|getValueC|-------"+pbc.getValueC());
		return "ValueA="+pbc.getValueA()+"\n ValueB="+pbc.getValueB()+"\n ValueC="+pbc.getValueC();

	}
	
}