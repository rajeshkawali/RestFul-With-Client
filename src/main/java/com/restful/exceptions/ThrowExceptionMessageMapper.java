package com.restful.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.restful.model.ErrorMessage;

@Provider
public class ThrowExceptionMessageMapper implements ExceptionMapper<ThrowExceptionMessage> {

	public Response toResponse(ThrowExceptionMessage ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://localhost:8080/RestFul/webapi/restfulpath/querytest");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
