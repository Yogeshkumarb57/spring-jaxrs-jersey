package com.spring.boot.jaxrs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Response response = null;
        if (exception instanceof RuntimeException) {
            response = handleRuntimeException((RuntimeException) exception);
        } else if (exception instanceof Exception) {
            response = handleException((Exception) exception);
        } else {
            exception.printStackTrace();
            response = Response.serverError().entity(exception.getMessage()).build();
        }
        return response;
    }

    //you can write your custom handling code
    private Response handleException(Exception ex) {
        ex.printStackTrace();
        return Response.serverError().entity(ex.getMessage()).build();
    }

    private Response handleRuntimeException(Exception ex) {
        ex.printStackTrace();
        return Response.serverError().entity(ex.getMessage()).build();
    }
}