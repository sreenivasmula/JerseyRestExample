package com.sreeni.jersey.rest.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sreeni.jersey.rest.exception.EmpNotFoundException;
import com.sreeni.jersey.rest.model.ErrorResponse;

@Provider
public class EmpNotFoundExceptionMapper implements
        ExceptionMapper<EmpNotFoundException> {

    public EmpNotFoundExceptionMapper() {
    }
    
    public Response toResponse(
            EmpNotFoundException empNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(empNotFoundException.getErrorId());
        errorResponse.setErrorCode(empNotFoundException.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                errorResponse).type(
                MediaType.APPLICATION_XML).build();

    }

}